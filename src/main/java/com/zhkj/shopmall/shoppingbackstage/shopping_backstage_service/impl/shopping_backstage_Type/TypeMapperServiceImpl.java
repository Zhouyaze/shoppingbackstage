package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Type;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.PromotionitemEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.TypeEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Type.TypeMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backage_Kafka.KafkaServiceImpl;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Type.TypeMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TypeMapperServiceImpl implements TypeMapperService {
    @Autowired
    KafkaServiceImpl kafkaService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Override
    public List<TypeEntity> getTypeInfo() {

        return typeMapper.getTypeInfo();
    }

    @Override
    public List<TypeEntity> getTypeNameById(  TypeEntity typeEntity) {
        return typeMapper.getTypeNameById(typeEntity);


    }

    @Override
    public int typeNameDelete(  TypeEntity typeEntity) {
        int result=typeMapper.typeNameDelete(typeEntity);
        if (result>0){
            try {
                kafkaService.kafka_del(String.valueOf(typeEntity.getId())
                        ,TypeEntity.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int typeNameUpdate(  TypeEntity typeEntity) {
        int result= typeMapper.typeNameUpdate(typeEntity);
        if (result>0){
            try {
                kafkaService.kafka_update(objectMapper.writeValueAsString(typeEntity)
                        ,String.valueOf(typeEntity.getId())
                        ,TypeEntity.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int typeNameAdd(  TypeEntity typeEntity) {
        int result= typeMapper.typeNameAdd(typeEntity);
        if (result>0){
            try {
                kafkaService.kafka_save(objectMapper.writeValueAsString(typeEntity)
                        ,String.valueOf(typeEntity.getId())
                        ,TypeEntity.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
