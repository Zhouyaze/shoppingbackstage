package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_controller.authenticationcontroller;


import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity.AuthenticationEntity;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.mapper.shopping_backstage_Authentication.AuthenticationServerMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class AuthenticationController {
@Autowired
AuthenticationServerMapperService authenticationServerMapperService;
    /**
     * 根据条件查询用户详细信息
     * @param authenticationEntity
     * @return
     */
    @GetMapping("/getAuthenicationById")
    public List<AuthenticationEntity> getAuthenicationById(AuthenticationEntity authenticationEntity){
        return authenticationServerMapperService.getAuthenicationById(authenticationEntity);
    }
    @GetMapping("/updateAuthentication")
    public int updateAuthentication(AuthenticationEntity authenticationEntity){
        return authenticationServerMapperService.updateAuthentication(authenticationEntity);
    }
}
