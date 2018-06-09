package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import org.springframework.stereotype.Repository;

import java.util.Objects;
@Repository
public class SpecificationsrelationEntity {
    private int id;
    private String specificationSku;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecificationSku() {
        return specificationSku;
    }

    public void setSpecificationSku(String specificationSku) {
        this.specificationSku = specificationSku;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecificationsrelationEntity that = (SpecificationsrelationEntity) o;
        return id == that.id &&
                Objects.equals(specificationSku, that.specificationSku);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, specificationSku);
    }
}
