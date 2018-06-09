package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_User;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.UsertypeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTypeMapper {
    /**
     * 查询全部用胡类型
     * @return
     */
    List<UsertypeEntity> selectUserType();
}
