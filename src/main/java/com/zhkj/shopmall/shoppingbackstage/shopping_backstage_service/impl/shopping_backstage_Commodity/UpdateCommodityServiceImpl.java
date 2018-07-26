package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Commodity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommodityEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommoditySpecificationInventoryPriceEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommodityintroducepictureEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.UserEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Commodity.UpdateCommodityMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backage_Kafka.KafkaServiceImpl;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Commodity.UpdateCommodityService;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UpdateCommodityServiceImpl implements UpdateCommodityService {


    @Autowired
    KafkaServiceImpl kafkaService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    UpdateCommodityMapper updateCommodityMapper;
    static  int number;
    @Override
    public int UpdateCommodity(CommodityEntity commodityEntity, MultipartFile picture) {
        if (picture!=null){
            Upload upload=new Upload();
            String file= upload.toupload(picture);
           commodityEntity.setBigPictureUrl(file);
        }
        int result=updateCommodityMapper.UpdateCommodity(commodityEntity);
        if (result>0){
            try {
                kafkaService.kafka_update(objectMapper.writeValueAsString(commodityEntity)
                        ,String.valueOf(commodityEntity.getId())
                        ,CommodityEntity.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int UpdateCommodityPrice(CommoditySpecificationInventoryPriceEntity priceEntity, MultipartFile img) {
        if (img!=null){
            Upload upload=new Upload();
            String file= upload.toupload(img);
            priceEntity.setPicture(file);

        }
        int result=updateCommodityMapper.UpdateCommodityPrice(priceEntity);
        if (result>0){
            try {
                kafkaService.kafka_update(objectMapper.writeValueAsString(priceEntity)
                        ,String.valueOf(priceEntity.getId())
                        ,CommoditySpecificationInventoryPriceEntity.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int UpdateCommodityPicture(CommodityintroducepictureEntity pictureEntity, MultipartFile picture) {
        if (picture!=null){
            Upload upload=new Upload();
            String file= upload.toupload(picture);
            pictureEntity.setPictureUrl(file);
        }
        int result=updateCommodityMapper.UpdateCommodityPicture(pictureEntity);
        if (result>0){
            try {
                kafkaService.kafka_update(objectMapper.writeValueAsString(pictureEntity)
                        ,String.valueOf(pictureEntity.getId())
                        ,CommodityintroducepictureEntity.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


}
