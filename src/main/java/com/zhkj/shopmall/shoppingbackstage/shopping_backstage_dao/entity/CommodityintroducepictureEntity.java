package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import java.util.Objects;

public class CommodityintroducepictureEntity {
    private int id;
    private String pictureUrl;
    private Integer commodityId;
    private int levels;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommodityintroducepictureEntity that = (CommodityintroducepictureEntity) o;
        return id == that.id &&
                levels == that.levels &&
                Objects.equals(pictureUrl, that.pictureUrl) &&
                Objects.equals(commodityId, that.commodityId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, pictureUrl, commodityId, levels);
    }
}
