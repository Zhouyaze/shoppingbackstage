package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import java.util.Objects;

public class ShoppingcartEntity {
    private int id;
    private Integer commodityNumber;
    private Integer commodityId;
    private String commodityName;
    private Integer commoditySipId;
    private Integer userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(Integer commodityNumber) {
        this.commodityNumber = commodityNumber;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public Integer getCommoditySipId() {
        return commoditySipId;
    }

    public void setCommoditySipId(Integer commoditySipId) {
        this.commoditySipId = commoditySipId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingcartEntity that = (ShoppingcartEntity) o;
        return id == that.id &&
                Objects.equals(commodityNumber, that.commodityNumber) &&
                Objects.equals(commodityId, that.commodityId) &&
                Objects.equals(commodityName, that.commodityName) &&
                Objects.equals(commoditySipId, that.commoditySipId) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, commodityNumber, commodityId, commodityName, commoditySipId, userId);
    }
}
