package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

public class PromotionitemEntity {
    private int id;
    private Timestamp startTime;
    private Timestamp endTime;
    private BigDecimal discountPrice;
    private int commodityNumber;
    private int commodityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(int commodityNumber) {
        this.commodityNumber = commodityNumber;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PromotionitemEntity that = (PromotionitemEntity) o;
        return id == that.id &&
                commodityNumber == that.commodityNumber &&
                commodityId == that.commodityId &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(discountPrice, that.discountPrice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, startTime, endTime, discountPrice, commodityNumber, commodityId);
    }
}
