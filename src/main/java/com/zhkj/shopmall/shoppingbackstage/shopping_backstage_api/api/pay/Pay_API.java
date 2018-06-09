package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.api.pay;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.PaywayEntity;

import java.util.List;

public interface Pay_API {
     int insertWay(PaywayEntity paywayEntity);
     int deleteWay(PaywayEntity paywayEntity);
     List<PaywayEntity> selectPay();
}
