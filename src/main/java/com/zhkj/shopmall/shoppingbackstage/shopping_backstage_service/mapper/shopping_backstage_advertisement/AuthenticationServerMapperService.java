package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_advertisement;


import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AuthenticationEntity;

import java.util.List;

public interface AuthenticationServerMapperService {
    /**
     * 根据地址id查询 地址信息
     * @return
     */
    List<AuthenticationEntity> getAuthenicationById(AuthenticationEntity authenticationEntity);

    /**
     * 根据实名认证id更改实名表信息
     * @param authenticationEntity
     * @return
     */
    int updateAuthentication(AuthenticationEntity authenticationEntity);
}
