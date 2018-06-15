package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import org.springframework.stereotype.Repository;

import java.util.Objects;
@Repository
public class AdvertisementplaceEntity {
    private int id;
    private String place;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdvertisementplaceEntity that = (AdvertisementplaceEntity) o;
        return id == that.id &&
                Objects.equals(place, that.place);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, place);
    }
}
