package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import java.util.Objects;

public class DictionaryEntity {
    private int id;
    private String type;
    private String showData;
    private String practicalData;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShowData() {
        return showData;
    }

    public void setShowData(String showData) {
        this.showData = showData;
    }

    public String getPracticalData() {
        return practicalData;
    }

    public void setPracticalData(String practicalData) {
        this.practicalData = practicalData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictionaryEntity that = (DictionaryEntity) o;
        return id == that.id &&
                Objects.equals(type, that.type) &&
                Objects.equals(showData, that.showData) &&
                Objects.equals(practicalData, that.practicalData);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, type, showData, practicalData);
    }
}
