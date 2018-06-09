package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_authentication;


import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AuthenticationEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthenticationMapper {
    /**
     * 根据地址id查询用户真实信息
     * @param authenticationEntity
     * @return
     */
    List<AuthenticationEntity> getAuthenicationById(AuthenticationEntity authenticationEntity);

    /**
     * 根据实名认证id更改实名认证信息
     * @param authenticationEntity
     * @return
     */
    int updateAuthentication(AuthenticationEntity authenticationEntity);
}
