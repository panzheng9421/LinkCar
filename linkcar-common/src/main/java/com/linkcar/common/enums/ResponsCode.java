package com.linkcar.common.enums;

/**
 * @author panzheng
 * @description 公共错误码接口
 * @date 2019/8/20 10:46
 */
public interface ResponsCode {

    /**
     * 错误码描述
     *
     * @return
     */
    String desc();

    /**
     * 错误码
     *
     * @return
     */
    String code();
}
