package com.zt.admin.service;

import com.zt.common.model.user.bean.UserInfo;
import com.zt.common.model.user.dao.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gaoxuejian on 2018/12/25.
 */
@Service
public class Demo1Service {
    @Autowired
    private UserInfoDao userInfoDao;
    public UserInfo getUserInfo(String uid){
        UserInfo userInfo= userInfoDao.getUserInfo(uid);
        return userInfo;
    }
}
