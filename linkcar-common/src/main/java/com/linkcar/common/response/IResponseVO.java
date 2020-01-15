package com.linkcar.common.response;

import java.util.Date;

/**
 * @author panzheng
 * @description 普通出参接口
 * @date 2019/8/20 12:03
 */
public interface IResponseVO {

    Date getResponseTime();

    String getCode();

    String getMsg();

    void setResponseTime(Date responseTime);

    void setCode(String code);

    void setMsg(String msg);

}
