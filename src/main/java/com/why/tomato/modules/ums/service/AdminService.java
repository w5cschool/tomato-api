package com.why.tomato.modules.ums.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.why.tomato.modules.ums.dto.UmsAdminParam;
import com.why.tomato.modules.ums.dto.UpdateAdminPasswordParam;
import com.why.tomato.modules.ums.model.UmsAdmin;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 后台管理员管理Service
 * Created by macro on 2018/4/26.
 */
public interface AdminService extends IService<UmsAdmin> {
    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);


    UmsAdmin getAdminByOpenId(String openid);

    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username,String password);

    /**
     * 刷新token的功能
     * @param oldToken 旧的token
     */
    String refreshToken(String oldToken);

    /**
     * 根据用户名或昵称分页查询用户
     */
    Page<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 修改指定用户信息
     */
    boolean update(Long id, UmsAdmin admin);

    /**
     * 删除指定用户
     */
    boolean delete(Long id);

    /**
     * 修改密码
     */
    int updatePassword(UpdateAdminPasswordParam updatePasswordParam);

    /**
     * 获取用户信息
     */
    UserDetails loadUserByOpenid(String openid);


    /**
     * 获取缓存服务
     */
    UmsAdminCacheService getCacheService();
}
