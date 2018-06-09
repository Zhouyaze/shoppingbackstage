package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class MycollectEntity {
    private int id;
    private Integer userId;
    private Integer commodityId;
    private String commodityIntroduce;
    private BigDecimal commodityPrice;
    private String smallPictureUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityIntroduce() {
        return commodityIntroduce;
    }

    public void setCommodityIntroduce(String commodityIntroduce) {
        this.commodityIntroduce = commodityIntroduce;
    }

    public BigDecimal getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(BigDecimal commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public String getSmallPictureUrl() {
        return smallPictureUrl;
    }

    public void setSmallPictureUrl(String smallPictureUrl) {
        this.smallPictureUrl = smallPictureUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MycollectEntity that = (MycollectEntity) o;
        return id == that.id &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(commodityId, that.commodityId) &&
                Objects.equals(commodityIntroduce, that.commodityIntroduce) &&
                Objects.equals(commodityPrice, that.commodityPrice) &&
                Objects.equals(smallPictureUrl, that.smallPictureUrl);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, commodityId, commodityIntroduce, commodityPrice, smallPictureUrl);
    }
}
