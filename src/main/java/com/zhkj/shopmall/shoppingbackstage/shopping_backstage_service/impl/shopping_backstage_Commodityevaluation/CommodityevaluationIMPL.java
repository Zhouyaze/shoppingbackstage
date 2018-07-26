package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Commodityevaluation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommodityEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommodityevaluationEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_commodityevaluation.CommodityevaluationDao;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backage_Kafka.KafkaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CommodityevaluationIMPL {

    @Autowired
    KafkaServiceImpl kafkaService;
    @Autowired
    private ObjectMapper objectMapper;
    int index=0;
    @Autowired
    CommodityevaluationDao commodityevaluationDao;
    public int add(CommodityevaluationEntity commodityevaluationEntity){
        if(commodityevaluationEntity!=null){
            index=commodityevaluationDao.addEvaluate(commodityevaluationEntity);
            if (index>0){
                try {
                    kafkaService.kafka_save(objectMapper.writeValueAsString(commodityevaluationEntity)
                            ,String.valueOf(commodityevaluationEntity.getId())
                            ,CommodityevaluationEntity.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return index;
    }
    public int delete(Integer id){
       index= commodityevaluationDao.deleteEvaluate(id);
        try {
            kafkaService.kafka_del(String.valueOf(id)
                    ,CommodityevaluationEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
       return index;
    }
}
