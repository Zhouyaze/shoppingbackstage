package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import java.math.BigDecimal;

public class CommodityDTO {
    private Integer id;
    private String commodityName;
    private String bigPictureUrl;
    private String typeName;
    private Integer commodityId;
    private String specification1;
    private String specification2;
    private String specification3;
    private String specification4;
    private Integer inventory;
    private BigDecimal price;
    private String picture;

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

    public String getBigPictureUrl() {
        return bigPictureUrl;
    }

    public void setBigPictureUrl(String bigPictureUrl) {
        this.bigPictureUrl = bigPictureUrl;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getSpecification1() {
        return specification1;
    }

    public void setSpecification1(String specification1) {
        this.specification1 = specification1;
    }

    public String getSpecification2() {
        return specification2;
    }

    public void setSpecification2(String specification2) {
        this.specification2 = specification2;
    }

    public String getSpecification3() {
        return specification3;
    }

    public void setSpecification3(String specification3) {
        this.specification3 = specification3;
    }

    public String getSpecification4() {
        return specification4;
    }

    public void setSpecification4(String specification4) {
        this.specification4 = specification4;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

}
