package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import java.util.Objects;

public class MenuEntity {
    private int id;
    private String menuName;
    private String showData;
    private String practicalData;
    private int order;
    private String link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getShowData() {
        return showData;
    }

    public void setShowData(String showData) {
        this.showData = showData;
    }

    public String getPracticalData() {
        return practicalData;
    }

    public void setPracticalData(String practicalData) {
        this.practicalData = practicalData;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuEntity that = (MenuEntity) o;
        return id == that.id &&
                order == that.order &&
                Objects.equals(menuName, that.menuName) &&
                Objects.equals(showData, that.showData) &&
                Objects.equals(practicalData, that.practicalData) &&
                Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, menuName, showData, practicalData, order, link);
    }
}
