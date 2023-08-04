package com.why.tomato.modules.ums.service;



import com.why.tomato.modules.ums.model.UmsAdmin;

/**
 * 后台用户缓存管理Service
 * Created by macro on 2020/3/13.
 */
public interface UmsAdminCacheService {
    /**
     * 删除后台用户缓存
     */
    void delAdmin(Long adminId);


    /**
     * 获取缓存后台用户信息
     */
    UmsAdmin getAdmin(String username);

    UmsAdmin getOpenid(String openid);

    /**
     * 设置缓存后台用户信息
     */
    void setAdmin(UmsAdmin admin);


    void setOpenid(UmsAdmin openid);


}
