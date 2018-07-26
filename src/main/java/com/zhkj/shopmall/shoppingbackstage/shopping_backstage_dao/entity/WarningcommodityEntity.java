package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class WarningcommodityEntity {
    private int id;
    private String commodityName;
    private String commoditySpecification;
    private int commodityCount;
    private String commoditySupplier;
    private Integer commodityWaitCount;
    private Date createTime;
    private int commodityState;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommoditySpecification() {
        return commoditySpecification;
    }

    public void setCommoditySpecification(String commoditySpecification) {
        this.commoditySpecification = commoditySpecification;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCommodityCount() {
        return commodityCount;
    }

    public void setCommodityCount(int commodityCount) {
        this.commodityCount = commodityCount;
    }

    public String getCommoditySupplier() {
        return commoditySupplier;
    }

    public void setCommoditySupplier(String commoditySupplier) {
        this.commoditySupplier = commoditySupplier;
    }

    public Integer getCommodityWaitCount() {
        return commodityWaitCount;
    }

    public void setCommodityWaitCount(Integer commodityWaitCount) {
        this.commodityWaitCount = commodityWaitCount;
    }


    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getCommodityState() {
        return commodityState;
    }

    public void setCommodityState(int commodityState) {
        this.commodityState = commodityState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarningcommodityEntity that = (WarningcommodityEntity) o;
        return id == that.id &&
                commodityCount == that.commodityCount &&
                commodityState == that.commodityState &&
                Objects.equals(commodityName, that.commodityName) &&
                Objects.equals(commoditySpecification, that.commoditySpecification) &&
                Objects.equals(commoditySupplier, that.commoditySupplier) &&
                Objects.equals(commodityWaitCount, that.commodityWaitCount) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, commodityName, commoditySpecification, commodityCount, commoditySupplier, commodityWaitCount, createTime, commodityState);
    }
}
