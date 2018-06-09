package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import java.util.Objects;

public class AuditgoodsEntity {
    private int id;
    private String goodsMsg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsMsg() {
        return goodsMsg;
    }

    public void setGoodsMsg(String goodsMsg) {
        this.goodsMsg = goodsMsg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditgoodsEntity that = (AuditgoodsEntity) o;
        return id == that.id &&
                Objects.equals(goodsMsg, that.goodsMsg);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, goodsMsg);
    }
}
