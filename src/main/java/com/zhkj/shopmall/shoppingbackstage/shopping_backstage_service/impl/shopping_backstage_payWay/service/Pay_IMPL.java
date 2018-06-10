package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_payWay.service;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.api.pay.Pay_API;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.PaywayEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_payWay.Pay_DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int insertWay(PaywayEntity paywayEntity) {
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
    public int updataWay(PaywayEntity paywayEntity) {
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
}
