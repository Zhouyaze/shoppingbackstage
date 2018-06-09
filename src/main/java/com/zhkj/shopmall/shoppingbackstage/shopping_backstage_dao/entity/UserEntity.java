package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;
@Repository
public class UserEntity {
    private Integer id;
    private String nickName;
    private String loginName;
    private String logingPassword;
    private String headPortraitUrl;
    private String userTypeName;
    private Integer authenticationId;
    private AuthenticationEntity authenticationEntity;
    private HarvestaddressEntity harvestaddressEntity;

    public HarvestaddressEntity getHarvestaddressEntity() {
        return harvestaddressEntity;
    }

    public void setHarvestaddressEntity(HarvestaddressEntity harvestaddressEntity) {
        this.harvestaddressEntity = harvestaddressEntity;
    }

    public AuthenticationEntity getAuthenticationEntity() {
        return authenticationEntity;
    }

    public void setAuthenticationEntity(AuthenticationEntity authenticationEntity) {
        this.authenticationEntity = authenticationEntity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLogingPassword() {
        return logingPassword;
    }

    public void setLogingPassword(String logingPassword) {
        this.logingPassword = logingPassword;
    }

    public String getHeadPortraitUrl() {
        return headPortraitUrl;
    }

    public void setHeadPortraitUrl(String headPortraitUrl) {
        this.headPortraitUrl = headPortraitUrl;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public Integer getAuthenticationId() {
        return authenticationId;
    }

    public void setAuthenticationId(Integer authenticationId) {
        this.authenticationId = authenticationId;
    }
}
