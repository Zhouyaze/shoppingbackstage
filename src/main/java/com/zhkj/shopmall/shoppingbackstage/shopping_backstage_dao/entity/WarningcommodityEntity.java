package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import java.util.Date;

public class WarningcommodityEntity {
    private Integer id;
    private String commodityName;
    private String commoditySpecification;
    private Integer commodityCount;
    private String commoditySupplier;
    private Integer commodityWaitCount;
    private Date createTime;
    private Integer commodityState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getCommodityCount() {
        return commodityCount;
    }

    public void setCommodityCount(Integer commodityCount) {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCommodityState() {
        return commodityState;
    }

    public void setCommodityState(Integer commodityState) {
        this.commodityState = commodityState;
    }
}
