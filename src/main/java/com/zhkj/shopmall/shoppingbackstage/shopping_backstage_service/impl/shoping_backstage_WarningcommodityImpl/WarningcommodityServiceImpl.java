package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shoping_backstage_WarningcommodityImpl;

import com.alibaba.fastjson.JSONObject;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo.WarnigcommodityVO;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.WarningcommodityEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shoping_backstage_Warningcommodity.WarningcommodityMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shoping_backstage_WarningcommodityService.WarningcommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WarningcommodityServiceImpl implements WarningcommodityService {


    @Autowired
    WarningcommodityMapper mapper;

    @KafkaListener(topics = "stock")
    public String ReceiveMessages(String json){
        //接收进货数据
        WarnigcommodityVO warnigcommodityVO= JSONObject.parseObject(json,WarnigcommodityVO.class);

        WarningcommodityEntity warningcommodityEntity=getWarningcommodityEntity(warnigcommodityVO);
        int no= mapper.saveWarning(warningcommodityEntity);
        if (no>0){
            return "成功";
        }
        return "失败";
    }





   private WarningcommodityEntity getWarningcommodityEntity(WarnigcommodityVO warnigcommodityVO){
        WarningcommodityEntity warningcommodityEntity=new WarningcommodityEntity();
        warningcommodityEntity.setCommodityName(warnigcommodityVO.getCommodityName());
        warningcommodityEntity.setCommoditySpecification(warnigcommodityVO.getCommoditySpecification());
        warningcommodityEntity.setCommodityCount(warnigcommodityVO.getCommodityCount());
        warningcommodityEntity.setCommoditySupplier(warnigcommodityVO.getCommoditySupplier());
        warningcommodityEntity.setCommodityWaitCount(warnigcommodityVO.getCommodityWaitCount());

       warningcommodityEntity.setCreateTime(warnigcommodityVO.getCreateTime());
        return warningcommodityEntity;
   }

}
