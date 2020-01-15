package com.linkcar.common.request;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * @author panzheng
 * @description 入参基类
 * @date 2019/8/20 11:30
 */
@NoArgsConstructor
public class BaseRequestVO implements IRequestVO, Serializable {
    private static final long serialVersionUID = 1067941824351445728L;
    private Date requestTime;

    @Override
    public String getRequestId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Override
    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

}
