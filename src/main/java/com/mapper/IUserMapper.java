package com.mapper;

import com.entity.user.User;

/**
 * @Author PengMvc
 * @Date 2022/5/23 21:15
 **/
public interface IUserMapper {

    public Boolean userLogin();

    public Boolean userRegister(User user);

}


