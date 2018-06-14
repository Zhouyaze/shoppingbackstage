package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import org.springframework.stereotype.Repository;
@Repository
public class CommodityEntity {
    private int id;
    private String commodityName;
    private String bigPictureUrl;
    private String typeName;

    private CommoditySpecificationInventoryPriceEntity priceEntity;

    public CommoditySpecificationInventoryPriceEntity getPriceEntity() {
        return priceEntity;
    }

    public void setPriceEntity(CommoditySpecificationInventoryPriceEntity priceEntity) {
        this.priceEntity = priceEntity;
    }

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

}
