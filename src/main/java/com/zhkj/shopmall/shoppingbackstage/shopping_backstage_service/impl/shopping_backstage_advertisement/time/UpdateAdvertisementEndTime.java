package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_advertisement.time;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AdvertisementEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_advertisement.Advertisement_DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
@Component
@EnableScheduling
public class UpdateAdvertisementEndTime {

    @Autowired
    Advertisement_DAO advertisement_dao;

    public  void  updateadvertisement(){
//        Date nowDate=new Date();
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String nowTime=simpleDateFormat.format(nowDate);
        List<AdvertisementEntity> advertisementEntities=advertisement_dao.selectEndTime();
        if (advertisementEntities!=null&&advertisementEntities.size() >0){
          advertisement_dao.updateStatus();
            System.out.println("改变结束时间状态");
       }
    }

    public void updateAdvertiseMentStartTime(){
        List<AdvertisementEntity> advertisementEntities=advertisement_dao.selectStartTime();
        if (advertisementEntities!=null&&advertisementEntities.size()>0){
            advertisement_dao.updateStratStatus();
            System.out.println("改变开始时间状态");
        }
    }
}
