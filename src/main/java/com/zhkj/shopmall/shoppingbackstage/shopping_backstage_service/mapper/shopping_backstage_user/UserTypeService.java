package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_user;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.UsertypeEntity;

import java.util.List;

public interface UserTypeService {
    /**
     * 查询全部用户类型
     * @return
     */
    List<UsertypeEntity> selectUserType();
}
