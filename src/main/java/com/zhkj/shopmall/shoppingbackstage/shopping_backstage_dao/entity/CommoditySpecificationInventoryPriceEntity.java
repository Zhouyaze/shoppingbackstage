package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class CommoditySpecificationInventoryPriceEntity {
    private int id;
    private int commodityId;
    private String specification1;
    private String specification2;
    private String specification3;
    private String specification4;
    private Integer inventory;
    private BigDecimal price;
    private String picture;
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

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommoditySpecificationInventoryPriceEntity that = (CommoditySpecificationInventoryPriceEntity) o;
        return id == that.id &&
                commodityId == that.commodityId &&
                inventory == that.inventory &&
                Objects.equals(specification1, that.specification1) &&
                Objects.equals(specification2, that.specification2) &&
                Objects.equals(specification3, that.specification3) &&
                Objects.equals(specification4, that.specification4) &&
                Objects.equals(price, that.price) &&
                Objects.equals(picture, that.picture);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, commodityId, specification1, specification2, specification3, specification4, inventory, price, picture);
    }
}
