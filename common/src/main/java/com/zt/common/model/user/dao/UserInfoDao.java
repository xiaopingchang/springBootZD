package com.zt.common.model.user.dao;

import com.zt.common.model.user.bean.UserInfo;
import com.zt.common.model.user.mapper.UserInfoMapper;
import com.zt.common.redis.dao.CacheDaoImpl;
import com.zt.common.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by gaoxuejian on 2018/12/25.
 */
@Repository
public class UserInfoDao extends CacheDaoImpl {
    @Autowired
    private UserInfoMapper userInfoMapper;
    public UserInfo getUserInfo(String uid){
        UserInfo cacheInfo = getObject(uid);
        if(CommonUtil.isEmpty(cacheInfo)){
            cacheInfo = userInfoMapper.selectByPrimaryKey(Integer.valueOf(uid));
            set(uid,cacheInfo);
        }
        return cacheInfo;
    }
}
