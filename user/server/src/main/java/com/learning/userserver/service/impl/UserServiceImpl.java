package com.learning.userserver.service.impl;

import com.learning.userserver.dataobject.UserInfo;
import com.learning.userserver.repository.UserInfoRepostory;
import com.learning.userserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserInfoRepostory userInfoRepostory;

    /**
     * 通过openid来查询用户信息
     * @param openid
     * @return
     */
    public UserInfo findByOpenid(String openid) {
        return userInfoRepostory.findByOpenid(openid);
    }
}
