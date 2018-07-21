package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backage_ReturnedServiceImpl;

import com.alibaba.fastjson.JSON;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo.ReturnedPurchaseVO;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommoditySpecificationInventoryPriceEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.ReturnedPurchaseEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity.SelectCommodidyMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity.UpdateCommodityMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_ReturnedPurchase.ReturnedPurchaseMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backage_ReturnedService.ReturnedPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnedPurchaseServiceImpl implements ReturnedPurchaseService {

    @Autowired
    ReturnedPurchaseMapper returnedPurchaseMapper;

    @Autowired
    SelectCommodidyMapper selectCommodidyMapper;

    @Autowired
    UpdateCommodityMapper updateCommodityMapper;

    /**
     * 添加退货商品信息
     * @param returnedPurchaseVO
     * @return
     */
    @Override
    public int saveReturned(ReturnedPurchaseVO returnedPurchaseVO) {
        String json="{\"messageType\": \"2\",\"manifest\": \"1234567890\", \"returnUserName\":\"郑国超\"," +
                "\"returnUserAddress\":\"河南省洛阳市涧西区几安南街33号3单元2号楼202\",\"commodityName\":\"苹果\"" +
                ",\"count\":\"9\",\"specification1\":\"褐色\",\"specification2\":\"xxxl\"" +
                ",\"specification3\":\"\",\"specification4\":\"\"}";
        //转换json为VO实体
        returnedPurchaseVO= JSON.parseObject(json,ReturnedPurchaseVO.class);
        ReturnedPurchaseEntity returnedPurchaseEntity=getReturnPurchaseEntity(returnedPurchaseVO);
        CommoditySpecificationInventoryPriceEntity priceEntity=getCommodity(returnedPurchaseVO);

        String sku=priceEntity.getSpecification1()+","+priceEntity.getSpecification2()
                +","+priceEntity.getSpecification3()+","+priceEntity.getSpecification4();
        returnedPurchaseEntity.setReturnCommoditySku(sku);

        returnedPurchaseEntity.setInventory(returnedPurchaseEntity.getInventory());
        return returnedPurchaseMapper.saveReturned(returnedPurchaseEntity);
    }

    /**
     * 退货处理 接收信息状态  同意 还是不同意
     * @param returnedPurchaseVO
     * @return
     */
    //@KafkaListener(topics="退货")
    public int insertReturned(ReturnedPurchaseVO returnedPurchaseVO) {
        String json="{\"messageType\": \"2\",\"manifest\": \"1234567890\", \"returnUserName\":\"郑国超\"," +
                "\"returnUserAddress\":\"河南省洛阳市涧西区几安南街33号3单元2号楼202\",\"commodityName\":\"苹果\"" +
                ",\"count\":\"9\",\"specification1\":\"褐色\",\"specification2\":\"xxxl\"" +
                ",\"specification3\":\"\",\"specification4\":\"\"}";
        //转换json为VO实体
        returnedPurchaseVO= JSON.parseObject(json,ReturnedPurchaseVO.class);
        ReturnedPurchaseEntity returnedPurchaseEntity=getReturnPurchaseEntity(returnedPurchaseVO);
        CommoditySpecificationInventoryPriceEntity priceEntity=getCommodity(returnedPurchaseVO);

        int no=returnedPurchaseEntity.getOperatingStatus();
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
//            //根据商品名区查询 商品id
//            int id=selectCommodidyMapper.seletCommodityId(returnedPurchaseVO.getCommodityName());
//            priceEntity.setCommodityId(id);
//            //查询剩余 商品数量
//            int count1=selectCommodidyMapper.selectCount(priceEntity);
//            count1=count1-returnedPurchaseEntity.getInventory();
//            priceEntity.setInventory(count1);
//            updateCommodityMapper.updateSpecification(priceEntity);
            returnedPurchaseEntity.setOperatingStatus(5);
        }
        return returnedPurchaseMapper.update(returnedPurchaseEntity);

    }

    /**
     * 传送进销存  （退货/进货）信息
     *
     * @return
     */
    @Override
    public String querReturned(ReturnedPurchaseEntity returnedPurchaseEntity) {
        returnedPurchaseEntity=returnedPurchaseMapper.querReturned(returnedPurchaseEntity);
        String sendJson=JSON.toJSONString(returnedPurchaseEntity);
        return sendJson;
    }


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
        returnedPurchaseEntity.setInventory(purchaseVO.getCount());

        return returnedPurchaseEntity;
    }
}
