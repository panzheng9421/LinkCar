package com.linkcar.common.enums;

/**
 * @author panzheng
 * @description 模块错误码
 * @date 2019/8/20 10:56
 */
public enum MouduleCodeEnum {

    /**
     * 用户中心
     */
    USER("21"),
    /**
     * 会员中心
     */
    MEMBER("22"),
    /**
     * 商品
     */
    GOODS("23"),
    /**
     * 库存
     */
    INVENTORY("24"),
    /**
     * 订单
     */
    ORDER("25"),
    /**
     * 支付
     */
    PAY("26");

    private String code;

    private MouduleCodeEnum(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }

}
