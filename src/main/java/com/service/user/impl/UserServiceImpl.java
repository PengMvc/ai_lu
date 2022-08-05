package com.service.user.impl;

import com.common.ailuenum.APICode;
import com.constant.CacheKeyConstant;
import com.controller.user.req.EditUserRequest;
import com.controller.user.req.LoginRequest;
import com.controller.user.req.UserRequest;
import com.define.exception.APIException;
import com.entity.user.User;
import com.mapper.IUserMapper;
import com.redis.RedisUtil;
import com.service.user.IUserService;
import com.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户实现类
 * @Author: PengMvc
 * @Date: 2022/05/24/19:05
 */
@Service
public class UserServiceImpl implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private IUserMapper userMapper;

    @Override
    public void userRegister(UserRequest req) {
        Boolean registerFlag = false;
        String userIdetityKey = CacheKeyConstant.USER_IDENTITY+req.getUserIdentityCard();

        // 从redis查询用户身份证信息
        String userIdentity = redisUtil.get(userIdetityKey);

        // 判断用户身份证，若存在，则直接去登录
        if(!StringUtils.isBlank(userIdentity)){
            throw new APIException(APICode.REPEAT_REGISTER);
        }

        // 用户注册
        try {
            registerFlag = userMapper.addUser(createUserInfo(req));
            if(registerFlag){
                // 用户身份证入redis
                redisUtil.set(userIdetityKey,req.getUserIdentityCard());
            }
        } catch (Exception e) {
            logger.error("用户注册失败",e);
            throw new APIException(APICode.FAIL_REGISTER);
        }
     }

    @Override
    public void userLogin(LoginRequest req) {

        String verifyKey = CacheKeyConstant.USER_VERIFY_KEY+req.getUserPhone();

        // get verifyCode from redis
        String verifyCode = redisUtil.get(verifyKey);

        // check verifyCode is eq or not
        if(!req.getVerifyCode().equals(verifyCode)){
            throw new APIException(APICode.VERITY_CODE_WRONG);
        }

        // get userInfo from mysql
        try {
            User user = userMapper.queryUserByCondition(createLoginUserInfo(req));
            if(!checkLoginParam(user,req)){
                throw new APIException(APICode.FAIL_LOGIN);
            }
        } catch (Exception e) {
            throw new APIException(APICode.FAIL_LOGIN);
        }
   }

    @Override
    public void editUserInfo(EditUserRequest req) {

        String userIdetityKey = CacheKeyConstant.USER_IDENTITY+req.getUserIdentityCard();

        // get user from redis,maybe get from mysql is plus
        String userIdentityCard = redisUtil.get(userIdetityKey);

        // if userIdentityCard is null or not
        if(StringUtils.isBlank(userIdentityCard)){
            throw new APIException(APICode.NOT_REGISTER);
        }

        // edit user
        try {
            userMapper.editUserInfo(req);
        } catch (Exception e) {
            throw new APIException(APICode.FAIL_EDIT_USER);
        }
    }

    /**
     * 封装user数据
     * @param req
     * @return
     */
    private User createUserInfo(UserRequest req){
        User user = new User();
        user.setLoginPwd(req.getLoginPwd());
        user.setUserPhone(req.getUserPhone());
        user.setUserId(123);
        user.setUserAddress(req.getUserAddress());
        user.setUserName(req.getUserName());
        user.setUserIdentityCard(req.getUserIdentityCard());
        user.setSalary(req.getSalary());
        user.setSex(req.getSex());
        return user;
    }

    /**
     * check login userPhone and pwd
     * @param user
     * @param req
     * @return true or false
     */
    private Boolean checkLoginParam(User user,LoginRequest req){
        if(StringUtils.isEqual(user.getUserPhone(),req.getUserPhone()) &&
        StringUtils.isEqual(user.getLoginPwd(),req.getLoginPwd())){
            return true;
        }
      return false;
    }

    private User createLoginUserInfo(LoginRequest req){
        User user = new User();
        user.setUserPhone(req.getUserPhone());
        user.setLoginPwd(req.getLoginPwd());
        return user;
    }
}
