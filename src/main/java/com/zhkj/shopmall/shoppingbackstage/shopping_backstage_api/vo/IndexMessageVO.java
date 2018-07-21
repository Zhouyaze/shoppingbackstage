package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo;

public class IndexMessageVO {

    public static final String TOPIC_COMMODITY="commodity";
    public static final String TOPIC_COMMODITYTYPERELATION="commoditytyperelation";
    public static final String TOPIC_DISCOUNT="discount";
    public static final String TOPIC_PROMOTIONITEM="promotionitem";
    public static final String TOPIC_SPECIFICATIONSDETAILED="specificationsdetailed";
    public static final String TOPIC_SPECIFICATIONSRELATION="specificationsrelation";
    public static final String TOPIC_SPECIFICATIONSTOPIC="specificationstopic";
    public static final String TOPIC_TYPE="type";


    public static final String SAVE="save";
    public static final String DEL="del";
    public static final String UPDATE="update";
    /**最多重试次数*/
    public static final int MAX_RETRY=3;

    /**对应要做的变动(SAVE DEL UPDATE)*/
    private String operation;
    /**对应重试次数(MAX_RETRY)*/
    private int retry = 0;
    /**存入的对象(要转换成json)*/
    private String object;
    /**
     * 对象的ID
     */
    private String id;

    public IndexMessageVO(){}

    public IndexMessageVO(String operation, String object, String id){
        this.operation=operation;
        this.object=object;
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String table) {
        this.id = table;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getRetry() {
        return retry;
    }

    public void setRetry(int retry) {
        this.retry = retry;
    }

    public String getObjects() {
        return object;
    }

    public void setObjects(String objects) {
        this.object = objects;
    }

}
