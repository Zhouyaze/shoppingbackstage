package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backstage_Authentication;

import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AuthenticationEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.mapper.shopping_backstage_authentication.AuthenticationMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Authentication.AuthenticationServerMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationMapperServiceImpl implements AuthenticationServerMapperService {
    @Autowired
    private AuthenticationMapper authenticationMapper;
    @Override
    public List<AuthenticationEntity> getAuthenicationById(AuthenticationEntity authenticationEntity) {
        return authenticationMapper.getAuthenicationById(authenticationEntity);
    }

    @Override
    public int updateAuthentication(AuthenticationEntity authenticationEntity) {
        return authenticationMapper.updateAuthentication(authenticationEntity);
    }

}
