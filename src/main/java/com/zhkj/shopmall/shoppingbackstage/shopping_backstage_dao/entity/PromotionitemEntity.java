package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class PromotionitemEntity {
    private int id;
    private Date startTime;
    private Date endTime;
    private BigDecimal discountPrice;
    private Integer commodityNumber;
    private Integer commodityId;
    private String specifications1;
    private String specifications2;
    private String specifications3;
    private String specifications4;
    private CommodityEntity commodityEntity;

    public CommodityEntity getCommodityEntity() {
        return commodityEntity;
    }

    public void setCommodityEntity(CommodityEntity commodityEntity) {
        this.commodityEntity = commodityEntity;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
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

    public String getSpecifications1() {
        return specifications1;
    }

    public void setSpecifications1(String specifications1) {
        this.specifications1 = specifications1;
    }

    public String getSpecifications2() {
        return specifications2;
    }

    public void setSpecifications2(String specifications2) {
        this.specifications2 = specifications2;
    }

    public String getSpecifications3() {
        return specifications3;
    }

    public void setSpecifications3(String specifications3) {
        this.specifications3 = specifications3;
    }

    public String getSpecifications4() {
        return specifications4;
    }

    public void setSpecifications4(String specifications4) {
        this.specifications4 = specifications4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PromotionitemEntity that = (PromotionitemEntity) o;
        return id == that.id &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(discountPrice, that.discountPrice) &&
                Objects.equals(commodityNumber, that.commodityNumber) &&
                Objects.equals(commodityId, that.commodityId) &&
                Objects.equals(specifications1, that.specifications1) &&
                Objects.equals(specifications2, that.specifications2) &&
                Objects.equals(specifications3, that.specifications3) &&
                Objects.equals(specifications4, that.specifications4);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, startTime, endTime, discountPrice, commodityNumber, commodityId, specifications1, specifications2, specifications3, specifications4);
    }
}
