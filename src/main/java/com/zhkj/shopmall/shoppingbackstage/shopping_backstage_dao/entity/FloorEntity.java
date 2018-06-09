package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import java.util.Objects;

public class FloorEntity {
    private int id;
    private String title;
    private String logoUrl;
    private int order;

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

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FloorEntity that = (FloorEntity) o;
        return id == that.id &&
                order == that.order &&
                Objects.equals(title, that.title) &&
                Objects.equals(logoUrl, that.logoUrl);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, logoUrl, order);
    }
}
