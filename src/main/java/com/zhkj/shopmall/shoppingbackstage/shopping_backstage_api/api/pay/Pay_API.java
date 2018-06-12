package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.api.pay;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.PaywayEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface Pay_API {
     int insertWay(PaywayEntity paywayEntity,MultipartFile File);
     int deleteWay(PaywayEntity paywayEntity);
     int updataWay(PaywayEntity paywayEntity,MultipartFile file);
     List<PaywayEntity> selectPay();
}
