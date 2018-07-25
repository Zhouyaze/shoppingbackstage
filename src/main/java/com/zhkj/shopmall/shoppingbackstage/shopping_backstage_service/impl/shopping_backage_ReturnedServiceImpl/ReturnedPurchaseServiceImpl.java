package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backage_ReturnedServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo.ReturnedPurchaseVO;
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
     * 添加   退货   发货  商品信息
     * @param returnedPurchaseVO
     * @return
     */
    //@Override
    @KafkaListener(topics="订单")
    public String saveReturned(ReturnedPurchaseVO returnedPurchaseVO) {
        ReturnedPurchaseEntity returnedPurchaseEntity=getReturnPurchaseEntity(returnedPurchaseVO);
        CommoditySpecificationInventoryPriceEntity priceEntity=getCommodity(returnedPurchaseVO);
        StringBuffer stringBufferSku = new StringBuffer();
        int sendtype=returnedPurchaseEntity.getMessageType();
        if(null != priceEntity.getSpecification1()) stringBufferSku.append(priceEntity.getSpecification1() + ",");
        if(null != priceEntity.getSpecification2()) stringBufferSku.append(priceEntity.getSpecification2() + ",");
        if(null != priceEntity.getSpecification3()) stringBufferSku.append(priceEntity.getSpecification3() + ",");
        if(null != priceEntity.getSpecification4()) stringBufferSku.append(priceEntity.getSpecification4());
        returnedPurchaseEntity.setReturnCommoditySku(stringBufferSku.toString());
        returnedPurchaseEntity.setInventory(returnedPurchaseEntity.getInventory());
        /**
         * 获取当前登陆人
         */
        //returnedPurchaseEntity.setBackstageHandlersint(session.getAttribute("loginName").toString());
        //传入消息表
             int no= returnedPurchaseMapper.saveReturned(returnedPurchaseEntity);
             if (no>0){
                 return "成功添加消息表";
             }
             return "添加失败";
    }



    @KafkaListener(topics = "test")
    public void getMsg(String content){
        System.out.println("测试"+content);
    }

    /**
     * 退货处理 接收信息状态 同意 还是不同意
     * 订单发货 接收信息状态 同意 还是不同意
     * @param returnedPurchaseVO
     * @return
     */
    @KafkaListener(topics="test")
    public String querReturned(ReturnedPurchaseVO returnedPurchaseVO) {

        ReturnedPurchaseEntity returnedPurchaseEntity=getReturnPurchaseEntity(returnedPurchaseVO);
        CommoditySpecificationInventoryPriceEntity priceEntity=getCommodity(returnedPurchaseVO);
        int number=returnedPurchaseEntity.getMessageType();
        int no=returnedPurchaseEntity.getOperatingStatus();
        //消息类型 1:进货 2:退货 3:订单
        if (number==1){//类型 进货

        }else if(number==2){//类型等于退货
            if (no==4){
                //根据商品名区查询 商品id
                int id=selectCommodidyMapper.seletCommodityId(returnedPurchaseVO.getCommodityName());
                priceEntity.setCommodityId(id);
                //查询剩余 商品数量
                int count1=selectCommodidyMapper.selectCount(priceEntity);
                count1=count1+returnedPurchaseEntity.getInventory();
                priceEntity.setInventory(count1);
                updateCommodityMapper.updateSpecification(priceEntity);
            }else {
                returnedPurchaseEntity.setOperatingStatus(5);
            }
        }else if (number==3){//类型等于订单
            if (no==4){
                orderFromMapper.updateOrderFrom(returnedPurchaseEntity.getManifest());
            }else {
                returnedPurchaseEntity.setOperatingStatus(5);
            }
        }
        returnedPurchaseMapper.update(returnedPurchaseEntity);
        return "成功";

    }

    /**
     * 传送进销存  （退货/进货）信息
     * @return
     */
    @Override
    public int querReturn(ReturnedPurchaseEntity returnedPurchaseEntity) {

         returnedPurchaseEntity=returnedPurchaseMapper.querReturn(returnedPurchaseEntity);
         //kafkaTemplate.send("",returnedPurchas.);
        return 1;
    }


    @Override
    public List<ReturnedPurchaseEntity> selectType(ReturnedPurchaseEntity returnedPurchaseEntity) {
        return returnedPurchaseMapper.selectType(returnedPurchaseEntity);
    }


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
