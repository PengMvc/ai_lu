package com.service.user;

import com.common.BaseResponse;
import com.controller.user.req.RegisterRequest;

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
    public void userRegister(RegisterRequest req);
}
