package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
@Repository
public class OrderfromEntity {
    private Integer id;
    private String orderNumber;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp orderCreationTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp orderEndTime;
    private Integer userId;
    private Integer paymentTypeId;
    private BigDecimal orderfromPrice;
    private Integer harvestAddressId;
    private String transactionNumber;
    private UserEntity userEntity;
    private OrderfromshopEntity orderfromshopEntity;
    private HarvestaddressEntity harvestAddressEntity;
    private OrderfromEntity orderfromEntity;
    public HarvestaddressEntity getHarvestAddressEntity() {
        return harvestAddressEntity;
    }

    public void setHarvestAddressEntity(HarvestaddressEntity harvestAddressEntity) {
        this.harvestAddressEntity = harvestAddressEntity;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public UserEntity getUserEntity() {
        return userEntity;
    }
    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
    public OrderfromshopEntity getOrderfromshopEntity() {

        return orderfromshopEntity;
    }

    public void setOrderfromshopEntity(OrderfromshopEntity orderfromshopEntity) {
        this.orderfromshopEntity = orderfromshopEntity;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Timestamp getOrderCreationTime() {
        return orderCreationTime;
    }

    public void setOrderCreationTime(Timestamp orderCreationTime) {
        this.orderCreationTime = orderCreationTime;
    }

    public Timestamp getOrderEndTime() {
        return orderEndTime;
    }

    public void setOrderEndTime(Timestamp orderEndTime) {
        this.orderEndTime = orderEndTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Integer paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public BigDecimal getOrderfromPrice() {
        return orderfromPrice;
    }

    public void setOrderfromPrice(BigDecimal orderfromPrice) {
        this.orderfromPrice = orderfromPrice;
    }

    public Integer getHarvestAddressId() {
        return harvestAddressId;
    }

    public void setHarvestAddressId(Integer harvestAddressId) {
        this.harvestAddressId = harvestAddressId;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

}
