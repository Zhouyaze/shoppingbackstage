package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Commodity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommodityEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommoditySpecificationInventoryPriceEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommoditySpecificationRelationEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.UserEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity.DeleteCommodityMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backage_Kafka.KafkaServiceImpl;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Commodity.DeleteCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DeleteCommodityServiceImpl implements DeleteCommodityService {
    @Autowired
    private KafkaServiceImpl kafkaService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    DeleteCommodityMapper delete;
    @Autowired
    SelectCommodidyServiceImpl select;

    @Override
    public int DeleteCommodity(Integer id) {
        int number = delete.DeleteCommodity(id);
        CommoditySpecificationInventoryPriceEntity c=
                select.selectAllspecification(id).get(0);
        int apId=c.getId();
        if (number > 0) {
            try {
                kafkaService.kafka_del(id.toString()
                        , CommodityEntity.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            number = delete.DeleteCommodityPicture(apId);
            try {
                kafkaService.kafka_del(String.valueOf(apId)
                        ,CommoditySpecificationInventoryPriceEntity.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return number;
    }

    /**
     * 删除商品规格表某列
     *
     * @param id 参数 【规格表主键id】
     * @return
     */
    @Override
    public int DeleteCommoditySpecification(Integer id) {
        int number = delete.DeleteCommoditySpecification(id);
        try {
            kafkaService.kafka_del(id.toString()
                    , CommoditySpecificationRelationEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return number;
    }

}
