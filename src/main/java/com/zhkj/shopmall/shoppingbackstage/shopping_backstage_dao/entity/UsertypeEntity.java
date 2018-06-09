package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;
@Repository
public class UsertypeEntity {
    private int id;
    private String userTypeName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsertypeEntity that = (UsertypeEntity) o;
        return id == that.id &&
                Objects.equals(userTypeName, that.userTypeName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userTypeName);
    }
}
