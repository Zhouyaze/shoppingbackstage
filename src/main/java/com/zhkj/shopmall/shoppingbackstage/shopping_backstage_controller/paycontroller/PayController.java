package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller.paycontroller;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.PaywayEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_payWay.service.Pay_IMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PayController {
     @Autowired
     Pay_IMPL pay_impl;
    @RequestMapping("/insertPay")
     public String insertPay(@ModelAttribute PaywayEntity paywayEntity){
         int index=0;
         index=pay_impl.insertWay(paywayEntity);
         if(index>0){
             return "添加支付方式成功";
         }else {
             return "添加支付方式失败";
         }
     }
    @RequestMapping("/deletePay")
    public String deletePay(@ModelAttribute PaywayEntity paywayEntity){
        int index=0;
        index=pay_impl.deleteWay(paywayEntity);
        if(index>0){
            return "删除支付方式成功";
        }else {
            return "删除支付方式失败";
        }
    }
    @RequestMapping("/selectPay")
    public List<PaywayEntity> selectPay(){
      List<PaywayEntity>paywayEntity=new ArrayList<>();
       paywayEntity=pay_impl.selectPay();
       return paywayEntity;
    }
}
