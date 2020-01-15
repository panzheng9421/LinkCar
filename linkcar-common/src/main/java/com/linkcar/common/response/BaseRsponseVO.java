package com.linkcar.common.response;

import com.linkcar.common.enums.CommonCodeEnum;
import com.linkcar.common.enums.ResponsCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author panzheng
 * @description 出参基类
 * @date 2019/8/20 12:16
 */
public class BaseRsponseVO<T> implements IResponseVO, Serializable {

    private static final long serialVersionUID = -3432898584644838740L;

    // 服务器响应时间
    private Date responseTime;
    // 返回码
    private String code;
    // 返回描述
    private String msg;
    // 返回内容
    private T content;

    @Override
    public Date getResponseTime() {
        return responseTime;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public T getContent() {
        return content;
    }

    @Override
    public void setResponseTime(Date responseTime) {
        this.responseTime = new Date();
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setContent(T content) {
        this.content = content;
    }

    protected void onResponse() {
        this.responseTime = new Date();
    }

    /**
     * 成功
     */
    public void sucess() {
        onResponse();
        this.code = CommonCodeEnum.SUCCESS.code();
        this.msg = CommonCodeEnum.SUCCESS.desc();
    }

    /**
     * 失败
     *
     * @param code
     */
    public void fail(ResponsCode code) {
        fail(code, null);
    }

    public void fail(ResponsCode code, String msg) {
        onResponse();
        if (msg != null) {
            this.msg = msg;
        } else {
            this.msg = code.desc();
        }
        this.code = code.code();
    }

}
