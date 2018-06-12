package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_payWay;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.PaywayEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Repository
public interface Pay_DAO {
    int insertWay(PaywayEntity paywayEntity);
    int deleteWay(PaywayEntity paywayEntity);
    int updataWay(PaywayEntity paywayEntity);
    List<PaywayEntity> selectPay();
}
