package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo;

import java.util.Date;

public class WarnigcommodityVO {

    private String commodityName;
    private String commoditySpecification;
    private int commodityCount;
    private String commoditySupplier;
    private int commodityWaitCount;
    private Date createTime;

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

    public int getCommodityWaitCount() {
        return commodityWaitCount;
    }

    public void setCommodityWaitCount(int commodityWaitCount) {
        this.commodityWaitCount = commodityWaitCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
