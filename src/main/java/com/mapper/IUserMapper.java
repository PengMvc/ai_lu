package com.mapper;

import com.controller.user.req.EditUserRequest;
import com.entity.user.User;

/**
 * @Author PengMvc
 * @Date 2022/5/23 21:15
 **/
public interface IUserMapper {

    /**
     * 按条件查询用户
     * @return User
     */
    public User queryUserByCondition(User user);

    /**
     * 新增用户
     * @param user
     * @return true or false
     */
    public Boolean addUser(User user);

    /**
     *修改用户
     * @param req
     */
    public void editUserInfo(EditUserRequest req);
}


