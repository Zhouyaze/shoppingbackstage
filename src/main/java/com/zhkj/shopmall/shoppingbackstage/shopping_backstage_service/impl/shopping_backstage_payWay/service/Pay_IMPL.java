package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_payWay.service;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.api.pay.Pay_API;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.PaywayEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_payWay.Pay_DAO;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class Pay_IMPL implements Pay_API {
    @Autowired
    Pay_DAO pay_dao;
    /**
     * 添加支付方式
     * */
    @Override
    public int insertWay(PaywayEntity paywayEntity, MultipartFile file) {
        String imgPathUrl="";
        if (null != file){
            Upload upload=new Upload();
            imgPathUrl= upload.toupload(file);
            String path=imgPathUrl;
            paywayEntity.setPictureUrl(path);
        }
        int index=0;
        if(paywayEntity!=null){
           index= pay_dao.insertWay(paywayEntity);
        }
        return index;
    }

    /**
     * 删除支付方式
     * */
    @Override
    public int deleteWay(PaywayEntity paywayEntity) {
        int index=0;
        if(paywayEntity!=null){
            index= pay_dao.deleteWay(paywayEntity);
        }
        return index;
    }

    /**
     * 修改支付方式
     * @param paywayEntity
     * @return
     */
    @Override
    public int updataWay(PaywayEntity paywayEntity, MultipartFile file) {
        String imgPathUrl="";
        if (null!=file){
            Upload upload=new Upload();
            imgPathUrl= upload.toupload(file);
            String path=imgPathUrl;
            paywayEntity.setPictureUrl(path);
        }
        int index=0;
        if(paywayEntity!=null){
            index= pay_dao.updataWay(paywayEntity);
        }
        return index;
    }

    /**
     * 查询支付方式
     * */
    @Override
    public List<PaywayEntity> selectPay() {
        List<PaywayEntity> paywayEntity=new ArrayList<>();
        paywayEntity=pay_dao.selectPay();
        return paywayEntity;
    }


    /**
     * 转换类型
     *
     * @param studentEntityList 要转换的类型
     * @return 转换后的类型
     */
    private List<String[]> convertList(List<PaywayEntity> studentEntityList){
        List<String[]> list = null;
        if(null != studentEntityList && studentEntityList.size() > 0){
            list = new ArrayList<>();
            for(PaywayEntity studentEntity : studentEntityList){
                String[] strings = new String[]
                        {studentEntity.getId().toString(),studentEntity.getPayWayName(),studentEntity.getPayStatus().toString(),studentEntity.getPayInterface(),studentEntity.getPictureUrl()};
                list.add(strings);
            }
        }
        return list;
    }
}
