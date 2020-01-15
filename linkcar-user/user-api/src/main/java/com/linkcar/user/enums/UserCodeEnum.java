package com.linkcar.user.enums;

import com.linkcar.common.enums.MouduleCodeEnum;
import com.linkcar.common.enums.ResponsCode;

/**
 * 用户中心返回码
 *
 * @author panzheng
 * @description
 * @date 2020/1/7 15:21
 */
public interface UserCodeEnum {

    /**
     * 用户模块
     * 三到五位接口编号预留 100-149
     * 五到七位错误编码
     */
    public enum UserErrorCodeEnum implements ResponsCode {
        /**
         * 接口：getUserById 编号：100
         */
        GET_USER_NOT_EXISTS("100", "01", "参数错误，用户信息不存在！");
        private String desc;
        private String code;

        private UserErrorCodeEnum(String interfaceCode, String code, String desc) {
            this.code = MouduleCodeEnum.USER.code() + interfaceCode + code;
            this.desc = desc;
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

}
