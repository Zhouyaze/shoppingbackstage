package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import java.util.Objects;

public class ManagerEntity {
    private int id;
    private String loginName;
    private String loginPassword;
    private String headPortraitUrl;
    private Integer powerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getHeadPortraitUrl() {
        return headPortraitUrl;
    }

    public void setHeadPortraitUrl(String headPortraitUrl) {
        this.headPortraitUrl = headPortraitUrl;
    }

    public Integer getPowerId() {
        return powerId;
    }

    public void setPowerId(Integer powerId) {
        this.powerId = powerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManagerEntity that = (ManagerEntity) o;
        return id == that.id &&
                Objects.equals(loginName, that.loginName) &&
                Objects.equals(loginPassword, that.loginPassword) &&
                Objects.equals(headPortraitUrl, that.headPortraitUrl) &&
                Objects.equals(powerId, that.powerId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, loginName, loginPassword, headPortraitUrl, powerId);
    }
}
