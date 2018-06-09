package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;
@Repository
public class TypeEntity {
    private int id;
    private String typeName;
    private int levels;
    private int parentId;

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

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeEntity that = (TypeEntity) o;
        return id == that.id &&
                levels == that.levels &&
                parentId == that.parentId &&
                Objects.equals(typeName, that.typeName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, typeName, levels, parentId);
    }
}
