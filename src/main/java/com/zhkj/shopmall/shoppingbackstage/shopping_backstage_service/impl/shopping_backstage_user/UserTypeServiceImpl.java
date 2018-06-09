package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_user;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.UsertypeEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_User.UserTypeMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_user.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeServiceImpl implements UserTypeService {
    @Autowired
    UserTypeMapper userTypeMapper;
    @Override
    public List<UsertypeEntity> selectUserType() {
        return userTypeMapper.selectUserType();
    }
}
