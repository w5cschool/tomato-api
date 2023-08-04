package com.why.tomato.modules.ums.service.impl;

import com.why.tomato.common.service.RedisService;
import com.why.tomato.modules.ums.mapper.UmsAdminMapper;
import com.why.tomato.modules.ums.model.UmsAdmin;
import com.why.tomato.modules.ums.service.UmsAdminCacheService;
import com.why.tomato.modules.ums.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 后台用户缓存管理Service实现类
 * Created by macro on 2020/3/13.
 */
@Service
public class UmsAdminCacheServiceImpl implements UmsAdminCacheService {
    @Autowired
    private AdminService adminService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private UmsAdminMapper adminMapper;

    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;

    @Value("${redis.key.openid}")
    private String REDIS_KEY_OPENID;

    @Value("${redis.key.resourceList}")
    private String REDIS_KEY_RESOURCE_LIST;

    @Override
    public void delAdmin(Long adminId) {
        UmsAdmin admin = adminService.getById(adminId);
        if (admin != null) {
            String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getUsername();
            redisService.del(key);
        }
    }

    @Override
    public UmsAdmin getAdmin(String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + username;
        return (UmsAdmin) redisService.get(key);
    }

    @Override
    public void setAdmin(UmsAdmin admin) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getUsername();
        redisService.set(key, admin, REDIS_EXPIRE);
    }

    @Override
    public UmsAdmin getOpenid(String openid) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_OPENID + ":" + openid;
        return (UmsAdmin) redisService.get(key);
    }

    @Override
    public void setOpenid(UmsAdmin openid) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_OPENID + ":" + openid.getOpenid();
        redisService.set(key, openid, REDIS_EXPIRE);
    }

}
