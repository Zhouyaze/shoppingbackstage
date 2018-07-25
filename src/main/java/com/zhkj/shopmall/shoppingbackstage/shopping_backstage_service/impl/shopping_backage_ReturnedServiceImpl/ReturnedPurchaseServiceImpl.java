package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backage_ReturnedServiceImpl;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo.ReceiveMessageVO;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo.ReturnedPurchaseVO;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo.SendMessageVO;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommoditySpecificationInventoryPriceEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.ReturnedPurchaseEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity.SelectCommodidyMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity.UpdateCommodityMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_OrderFrom.OrderFromMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_ReturnedPurchase.ReturnedPurchaseMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backage_ReturnedService.ReturnedPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service

public class ReturnedPurchaseServiceImpl implements ReturnedPurchaseService {

//    @Autowired
//    KafkaServiceImpl kafkaService;
    @Autowired
    KafkaTemplate kafkaTemplate;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    ReturnedPurchaseMapper returnedPurchaseMapper;

    @Autowired
    SelectCommodidyMapper selectCommodidyMapper;

    @Autowired
    UpdateCommodityMapper updateCommodityMapper;

    @Autowired
    OrderFromMapper orderFromMapper;

    HttpSession session;


    /**
     * 退货   发货  商品信息
     * 文杰给我的kafka数据并存入消息表"
     * @param returnedPurchaseVO
     * @return 文杰        stock
     */
    //@Override
    @KafkaListener(topics="文杰给我的kafka数据并存入消息表")
    public String saveNews(ReturnedPurchaseVO returnedPurchaseVO) {
        ReturnedPurchaseEntity returnedPurchaseEntity=getReturnPurchaseEntity(returnedPurchaseVO);
        CommoditySpecificationInventoryPriceEntity priceEntity=getCommodity(returnedPurchaseVO);

        StringBuffer stringBufferSku = new StringBuffer();
        if(null != priceEntity.getSpecification1()){
            if(null == priceEntity.getSpecification2()){
                stringBufferSku.append(priceEntity.getSpecification1() + "-");
            }else {
                stringBufferSku.append(priceEntity.getSpecification1());
            }
        }
        if(null != priceEntity.getSpecification2()){
            if(null == priceEntity.getSpecification3()){
                stringBufferSku.append(priceEntity.getSpecification2() + "-");
            }else {
                stringBufferSku.append(priceEntity.getSpecification2());
            }
        }
        if(null != priceEntity.getSpecification3()){
            if(null == priceEntity.getSpecification4()){
                stringBufferSku.append(priceEntity.getSpecification3() + "-");
            }else {
                stringBufferSku.append(priceEntity.getSpecification3());
            }
        }
        if(null != priceEntity.getSpecification4())
        {
            stringBufferSku.append(priceEntity.getSpecification4());
        }
        returnedPurchaseEntity.setReturnCommoditySku(stringBufferSku.toString());
        /**
         * 获取当前登陆人
         */
        //returnedPurchaseEntity.setBackstageHandlersint(session.getAttribute("loginName").toString());
        //传入消息表
             int no= returnedPurchaseMapper.saveNews(returnedPurchaseEntity);
             if (no>0){
                 return "成功添加消息表";
             }
             return "添加失败";
    }


//    /**
//     * 测试  监听
//     * @param content
//     */
//    @KafkaListener(topics = "ShipmentReturnKafka")
//    public void getMsg(String content){
//        System.out.println("测试"+content);
//    }

    /**
     * 传送进销存  （退货/进货）信息
     * @return 发送 国超  退货 发货  信息 逐条发
     */
    @Override
    public String sendNews(ReturnedPurchaseEntity returnedPurchaseEntity) {
        returnedPurchaseEntity=returnedPurchaseMapper.sendNews(returnedPurchaseEntity);
        try {
            StringBuffer stringBufferSku = new StringBuffer();
            if(null != returnedPurchaseEntity.getReturnUserName()) stringBufferSku.append(returnedPurchaseEntity.getReturnUserName() + "-");
            if(null != returnedPurchaseEntity.getReturnCommoditySku()) stringBufferSku.append(returnedPurchaseEntity.getReturnCommoditySku() + "-");
            if(null != returnedPurchaseEntity.getReturnUserAddress()) stringBufferSku.append(returnedPurchaseEntity.getReturnUserAddress());
            returnedPurchaseEntity.setReturnCommoditySku(stringBufferSku.toString());

            returnedPurchaseEntity.setReturnCommoditySku(stringBufferSku.toString());

            SendMessageVO sendMessageVO=new SendMessageVO();
            sendMessageVO.setMessageContent(returnedPurchaseEntity.getReturnCommoditySku());
            sendMessageVO.setMessageStatus(3);
            sendMessageVO.setMessageToken(returnedPurchaseEntity.getManifest());
            sendMessageVO.setMessageTypeId(1);
            sendMessageVO.setSendMessageName(returnedPurchaseEntity.getBackstageHandlersint());
            sendMessageVO.setMessageTitle(returnedPurchaseEntity.getMessageType()==1?"发货":"退货");
            kafkaTemplate.send("ShipmentReturnKafka",objectMapper.writeValueAsString(sendMessageVO));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "成功";
    }

    /**
     * 进销存 返回Kafka 消息
     * 判断 是否已发货
     *      是否退货通过
     * @param
     * @return 监听   国超 返回信息
     */
    @KafkaListener(topics="ShipmentReturnKafka1")
    public String querReturned(String json) {
        Integer operatingStatus = 4;
        /**
         * 接收到的数据
         * 订单号
         * 消息类型 通过 不通过
         * 处理人
         */
        //接到数据转换为 json
        ReceiveMessageVO receiveMessageVO=  JSONObject.parseObject(json,ReceiveMessageVO.class);

        //获取 唯一标识
        String number=receiveMessageVO.getMessageToken();
        //测试  数量为10
//        receiveMessageVO.setInventory(10);
        //获取返回  type类型（发货 还是退货）
        int MessageType=receiveMessageVO.getType();
        //接收判断是否审核成功
        String YesOrNo=receiveMessageVO.getMessageState();
        int AuditNews;//审核消息
        if (YesOrNo.equals("审核成功")){
            AuditNews=1;
        }else {
            AuditNews=2;
        }

        if (MessageType==1){//类型 发货
            if (AuditNews==1){
                /**
                 * 已发货
                 * 需要数据 订单唯一标识    商品状态
                 * 根据唯一标识修改商品物流状态
                 */
                orderFromMapper.updateOrderFrom(receiveMessageVO.getMessageToken());
                returnedPurchaseMapper.updateNews(operatingStatus,number);

            }else {
                /**
                 * 未发货
                 * 不做修改订单物流状态
                 * 修改消息表  不通过
                 */
                operatingStatus=5;
                returnedPurchaseMapper.updateNews(operatingStatus,number);
            }
        }else if(MessageType==2){//类型等于退货
            if (AuditNews==1){

                /**
                 * 订单号 去查 规格id
                 * 根据规格 id  查库存
                 */
               int specificationsId  =returnedPurchaseMapper.slecctspecificationsId(receiveMessageVO.getMessageToken());

               int Inventory =returnedPurchaseMapper.sslectInventory(receiveMessageVO.getMessageToken());
                //查询剩余 商品数量
                int count1=selectCommodidyMapper.selectCount(specificationsId);
                //剩余数量 + 退货数量
                 int count2=count1+Inventory;
                //赋给  商品总数
                updateCommodityMapper.updateSpecification(specificationsId,count2);
                returnedPurchaseMapper.updateNews(operatingStatus,number);
//                //根据商品名区查询 商品id
//                int id=selectCommodidyMapper.seletCommodityId(returnedPurchaseVO.getCommodityName());
//                priceEntity.setCommodityId(id);
//                //查询剩余 商品数量
//                int count1=selectCommodidyMapper.selectCount(priceEntity);
//                //剩余数量 + 退货数量
//                count1=count1+returnedPurchaseEntity.getInventory();
//                //赋给  商品总数
//                priceEntity.setInventory(count1);
//                //添加商品库存
//                updateCommodityMapper.updateSpecification(priceEntity);
                /** 调用支付接口 退给客户钱**/
                //
                //退款接口
                //
            }else {
                /**
                 * 不同意退货
                 * 修改 消息表为  不通过
                 */
                operatingStatus=5;
                returnedPurchaseMapper.updateNews(operatingStatus,number);
            }
            //returnedPurchaseMapper.updateNews(operatingStatus,number);
        }
        return "成功";

    }






    /**
     * 前台 数据查询
     * @param returnedPurchaseEntity
     * @return
     */
    @Override
    public List<ReturnedPurchaseEntity> selectNews(ReturnedPurchaseEntity returnedPurchaseEntity) {
        return returnedPurchaseMapper.selectNews(returnedPurchaseEntity);
    }

//    @Override
//    public String querReturned(ReturnedPurchaseVO returnedPurchaseVO) {
//        return null;
//    }

    /**
     * 转换前台Vo数据 到实体
     * @param returnedPurchaseVO
     * @return
     */
    private CommoditySpecificationInventoryPriceEntity getCommodity(ReturnedPurchaseVO returnedPurchaseVO){
        CommoditySpecificationInventoryPriceEntity priceEntity=new CommoditySpecificationInventoryPriceEntity();
        priceEntity.setInventory(returnedPurchaseVO.getCount());
        priceEntity.setSpecification1(returnedPurchaseVO.getSpecification1());
        priceEntity.setSpecification2(returnedPurchaseVO.getSpecification2());
        priceEntity.setSpecification3(returnedPurchaseVO.getSpecification3());
        priceEntity.setSpecification4(returnedPurchaseVO.getSpecification4());
        return priceEntity;
    }

    /**
     * 转换前台Vo数据 到实体
     * @param purchaseVO
     * @return
     */
    private ReturnedPurchaseEntity getReturnPurchaseEntity(ReturnedPurchaseVO purchaseVO){
        ReturnedPurchaseEntity returnedPurchaseEntity=new ReturnedPurchaseEntity();
        //标识（1退货 2换货）
        returnedPurchaseEntity.setMessageType(purchaseVO.getMessageType());
        //订单编号
        returnedPurchaseEntity.setManifest(purchaseVO.getManifest());
        //退货人姓名
        returnedPurchaseEntity.setReturnUserName(purchaseVO.getReturnUserName());
        //退货地址
        returnedPurchaseEntity.setReturnUserAddress(purchaseVO.getReturnUserAddress());
        //商品名
        returnedPurchaseEntity.setReturnCommodityName(purchaseVO.getCommodityName());
        //商品规格
        returnedPurchaseEntity.setReturnCommoditySku(purchaseVO.getCommoditySku());
        //商品数量
        returnedPurchaseEntity.setInventory(purchaseVO.getCount());
        returnedPurchaseEntity.setOperatingStatus(purchaseVO.getOperatingStatus());
        return returnedPurchaseEntity;
    }
}
