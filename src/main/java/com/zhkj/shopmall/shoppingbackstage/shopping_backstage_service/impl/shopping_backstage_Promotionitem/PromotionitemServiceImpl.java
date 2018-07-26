package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Promotionitem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.CommodityEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.PromotionitemEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_Promotionitem.PromotionitemMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backage_Kafka.KafkaServiceImpl;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Promotionitem.PromotionitemService;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@Service
public class PromotionitemServiceImpl implements PromotionitemService {

    @Autowired
    KafkaServiceImpl kafkaService;
    @Autowired
    private ObjectMapper objectMapper;
    PageBean<PromotionitemEntity> pageBean=new PageBean<>();

    @Autowired
    private PromotionitemMapper promotionitemMapper;

    /**
     * 添加促销商品
     *
     * @param promotionitemEntity
     * @return
     */
    @Override
    public int saveMsg(PromotionitemEntity promotionitemEntity) {
        Date startTime=(promotionitemEntity.getStartTime());
        Date endTime=promotionitemEntity.getEndTime();
        int result=promotionitemMapper.saveMsg(promotionitemEntity);
        if (result>0){
            try {
                kafkaService.kafka_save(objectMapper.writeValueAsString(promotionitemEntity)
                        ,String.valueOf(promotionitemEntity.getId())
                        ,PromotionitemEntity.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;

    }

    @Override
    public PageBean<PromotionitemEntity> getMsg(PromotionitemEntity promotionitemEntity,int currentPage) {
        pageBean.setPageSize(5);
        pageBean.setTotalNum(promotionitemMapper.countMsg(promotionitemEntity));
        pageBean.countPage(pageBean.getTotalNum(),currentPage,pageBean.getPageSize());
        pageBean.setItems(promotionitemMapper.getMsg(promotionitemEntity,pageBean.getStartIndex(),pageBean.getPageSize()));
        return pageBean;
    }

    @Override
    public List<PromotionitemEntity> getMsgByid(PromotionitemEntity promotionitemEntity) {
        return promotionitemMapper.getMsgByid(promotionitemEntity);
    }

    @Override
    public int updateMsg(PromotionitemEntity promotionitemEntity) {
        int result=promotionitemMapper.updateMsg(promotionitemEntity);
        if (result>0){
            try {
                kafkaService.kafka_update(objectMapper.writeValueAsString(promotionitemEntity)
                        ,String.valueOf(promotionitemEntity.getId())
                        ,PromotionitemEntity.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int delMsg(int id) {
        int result=promotionitemMapper.delMsg(id);
        if (result>0){
            try {
                kafkaService.kafka_del(String.valueOf(id)
                        ,PromotionitemEntity.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}