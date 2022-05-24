package com.service.impl.user;

import com.common.ailuenum.APICode;
import com.constant.CacheKeyConstant;
import com.controller.user.req.RegisterRequest;
import com.define.exception.APIException;
import com.entity.user.User;
import com.mapper.IUserMapper;
import com.redis.RedisUtil;
import com.service.user.IUserService;
import com.until.StringUtils;
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
    public void userRegister(RegisterRequest req) {
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
            registerFlag = userMapper.userRegister(createUserInfo(req));
            if(registerFlag){
                // 用户身份证入redis
                redisUtil.set(userIdetityKey,req.getUserIdentityCard());
            }
        } catch (Exception e) {
            logger.error("用户注册失败",e);
            throw new APIException(APICode.FAIL_REGISTER);
        }
     }

    /**
     * 封装user数据
     * @param req
     * @return
     */
    private User createUserInfo(RegisterRequest req){
        User user = new User();
        user.setUserId(123);
        user.setUserAddress(req.getUserAddress());
        user.setUserName(req.getUserName());
        user.setUserIdentityCard(req.getUserIdentityCard());
        user.setLoginPwd(req.getLoginPwd());
        user.setSalary(req.getSalary());
        user.setSex(req.getSex());
        user.setUserPhone(req.getUserPhone());
        return user;
    }

}
