package com.linkcar.common.enums;

/**
 * @author panzheng
 * @description 公共错误码
 * @date 2019/8/20 10:47
 */
public enum CommonCodeEnum implements ResponsCode {
    /**
     * 成功标识
     */
    SUCCESS("200", "SUCCESS"),
    /**
     * 参数格式错误
     */
    FORMAT_ERROR("201", "参数格式错误"),
    /**
     * 签名错误
     */
    SIGN_ERROR("202", "签名错误"),
    /**
     * 失败
     */
    FAIL("500", "网络超时，请稍后再访问!"),
    /**
     * 404错误
     */
    NOT_FOUND_ERROR("404", "资源不存在"),
    /**
     * 请求超时
     */
    TIME_OUT_ERROR("408", "请求超时"),
    /**
     * 请求实体过大
     */
    BEYOND_THE_SIZE_ERROR("413", "请求实体过大"),
    /**
     * 请求的URL过长
     */
    BEYOND_THE_LENGTH_ERROR("414", "请求的URL过长");

    private String desc;
    private String code;

    private CommonCodeEnum(String code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    @Override
    public String desc() {
        return this.desc;
    }

    @Override
    public String code() {
        return this.code;
    }

}
