package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;
@Repository
public class OrderfromtypeEntity {
    private int id;
    private String typeName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderfromtypeEntity that = (OrderfromtypeEntity) o;
        return id == that.id &&
                Objects.equals(typeName, that.typeName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, typeName);
    }
}
