package com.linkcar.user.service;

import com.linkcar.common.response.BaseRsponseVO;
import com.linkcar.common.utils.ConstantsEJS;
import com.linkcar.user.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = ConstantsEJS.FEIGN_VALUE_USER, contextId = "userService")
@RequestMapping(value = "/user", produces = {ConstantsEJS.REQUESTMAPPING_PRODUCES})
public interface IUserService {

    /**
     * 根据id获取用户信息
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    BaseRsponseVO<User> getUserById(@RequestParam("userId") Integer userId);

}