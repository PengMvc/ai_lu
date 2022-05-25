package com.service.user;

import com.controller.user.req.LoginRequest;
import com.controller.user.req.UserRequest;
import com.entity.user.User;

/**
 * 用户接口
 * @Author: PengMvc
 * @Date: 2022/05/24/19:01
 */
public interface IUserService {

    /**
     * 注册接口
     * @param req
     * @return
     */
    public void userRegister(UserRequest req);

    /**
     *用户登录
     */
    public void userLogin(LoginRequest req);
}
