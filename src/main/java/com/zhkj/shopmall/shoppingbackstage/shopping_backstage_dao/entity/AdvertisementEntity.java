package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import java.sql.Date;
import java.util.Objects;

public class AdvertisementEntity {
    private int id;
    private String title;
    private String pictureUrl;
    private Integer status;
    private int commodityId;
    private int type;
    private int floorId;
    private Date startTime;
    private Date endTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdvertisementEntity that = (AdvertisementEntity) o;
        return id == that.id &&
                commodityId == that.commodityId &&
                type == that.type &&
                floorId == that.floorId &&
                Objects.equals(title, that.title) &&
                Objects.equals(pictureUrl, that.pictureUrl) &&
                Objects.equals(status, that.status) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, pictureUrl, status, commodityId, type, floorId, startTime, endTime);
    }
}
