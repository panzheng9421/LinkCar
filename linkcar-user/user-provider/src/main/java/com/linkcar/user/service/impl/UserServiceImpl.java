package com.linkcar.user.service.impl;

import com.linkcar.common.enums.CommonCodeEnum;
import com.linkcar.common.exception.BusinessException;
import com.linkcar.common.response.BaseRsponseVO;
import com.linkcar.user.dao.read.UserReadDao;
import com.linkcar.user.entity.User;
import com.linkcar.user.enums.UserCodeEnum;
import com.linkcar.user.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserServiceImpl implements IUserService {
    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserReadDao userReadDao;

    @Override
    public BaseRsponseVO<User> getUserById(Integer userId) {
        BaseRsponseVO<User> baseRsponseVO = new BaseRsponseVO<>();
        try {
            User user = userReadDao.getById(userId);
            baseRsponseVO.setContent(user);
            baseRsponseVO.sucess();
        } catch (BusinessException e) {
            // 参数错误，用户信息不存在
            baseRsponseVO.fail(UserCodeEnum.UserErrorCodeEnum.GET_USER_NOT_EXISTS);
            log.error(
                    "[UserServiceImpl][getUserById]根据id[" + userId + "]取得用户表时出现异常：" + e.getMessage());
        } catch (Exception e) {
            baseRsponseVO.fail(CommonCodeEnum.FAIL);
            log.error("[UserServiceImpl][getUserById]根据id[" + userId + "]取得用户表时出现未知异常：", e);
        }
        return baseRsponseVO;
    }

}