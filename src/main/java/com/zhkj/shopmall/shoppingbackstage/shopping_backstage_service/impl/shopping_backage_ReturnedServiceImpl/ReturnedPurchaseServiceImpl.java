package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backage_ReturnedServiceImpl;

import com.alibaba.fastjson.JSON;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo.ReturnedPurchaseVO;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.ReturnedPurchaseEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_ReturnedPurchase.ReturnedPurchaseMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backage_ReturnedService.ReturnedPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnedPurchaseServiceImpl implements ReturnedPurchaseService {

    @Autowired
    ReturnedPurchaseMapper returnedPurchaseMapper;

    /**
     * 添加退货商品信息
     * @param returnedPurchaseVO
     * @return
     */
    @Override
    public int saveReturned(ReturnedPurchaseVO returnedPurchaseVO) {
        String json="{\"messageType\": \"2\",\"manifest\": \"1234567890\", \"returnUserName\":\"郑国超\"," +
                "\"returnUserAddress\":\"河南省洛阳市涧西区几安南街33号3单元2号楼202\",\"commodityName\":\"充气娃娃\"" +
                ",\"commoditySku\":\"175,65\"}";
        //转换json为VO实体
        returnedPurchaseVO= JSON.parseObject(json,ReturnedPurchaseVO.class);
        ReturnedPurchaseEntity returnedPurchaseEntity=getReturnPurchaseEntity(returnedPurchaseVO);

        return returnedPurchaseMapper.saveReturned(returnedPurchaseEntity);
    }

    /**
     * 传送进销存  （退货/进货）信息
     *
     * @return
     */
    @Override
    public int sendKafka(ReturnedPurchaseEntity returnedPurchaseEntity) {

        //实体转换json
        String sendJson =JSON.toJSONString(ReturnedPurchaseEntity.class);

        return 0;
    }


    @Override
    public ReturnedPurchaseEntity querReturned() {
        return null;
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
        return returnedPurchaseEntity;
    }
}
