package com.learning.userserver.service;

import com.learning.userserver.dataobject.UserInfo;

public interface UserService {

    /**
     * 通过openid来查询用户信息
     * @param openid
     * @return
     */
    UserInfo findByOpenid(String openid);
}
