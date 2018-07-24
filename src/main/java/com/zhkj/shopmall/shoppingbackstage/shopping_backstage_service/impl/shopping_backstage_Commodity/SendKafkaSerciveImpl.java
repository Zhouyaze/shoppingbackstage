package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Commodity;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo.CommoditySpecifications_VO;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommodityEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity.SendKafkaMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Commodity.SendKafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendKafkaSerciveImpl implements SendKafkaService {

    @Autowired
    private SendKafkaMapper sendKafkaMapper;

    @Override
    public String sendKafka(CommoditySpecifications_VO commoditySpecifications_vo) {


        return null;
    }


}
