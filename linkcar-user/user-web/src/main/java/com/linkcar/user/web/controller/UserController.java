package com.linkcar.user.web.controller;

import com.linkcar.common.controller.BaseController;
import com.linkcar.common.response.BaseRsponseVO;
import com.linkcar.user.entity.User;
import com.linkcar.user.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户中心
 */
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {
    @Resource
    private IUserService userService;

    /**
     * 通过id获取用户信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "info")
    public BaseRsponseVO<User> getMemberInfo(Integer id) {
        BaseRsponseVO<User> baseRsponseVO = userService.getUserById(id);
        return baseRsponseVO;
    }


}
