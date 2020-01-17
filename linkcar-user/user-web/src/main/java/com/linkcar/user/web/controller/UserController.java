package com.linkcar.user.web.controller;

import com.linkcar.common.controller.BaseController;
import com.linkcar.common.response.BaseRsponseVO;
import com.linkcar.user.entity.User;
import com.linkcar.user.service.IUserService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户中心
 */
@RestController
@RequestMapping(value = "/user")
@Api(value = "/user", description = "用户中心")
public class UserController extends BaseController {
    @Resource
    private IUserService userService;

    @ApiOperation(value = "查询用户信息", notes = "点击查看我的用户信息", httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功！", response = BaseRsponseVO.class),
            @ApiResponse(code = 2110001, message = "参数错误，用户信息不存在！", response = BaseRsponseVO.class),
            @ApiResponse(code = 500, message = "网络超时，请稍后再访问!")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "id", value = "用户id", paramType = "query", dataType = "Integer")
    })
    @GetMapping(value = "info")
    public BaseRsponseVO<User> getMemberInfo(Integer id) {
        BaseRsponseVO<User> baseRsponseVO = userService.getUserById(id);
        return baseRsponseVO;
    }


}
