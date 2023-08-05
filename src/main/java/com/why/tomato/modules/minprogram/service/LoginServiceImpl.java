package com.why.tomato.modules.minprogram.service;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONObject;
import com.why.tomato.modules.minprogram.dto.LoginResponse;
import com.why.tomato.modules.ums.model.UmsAdmin;
import com.why.tomato.modules.ums.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author why
 * @date 2023/8/3 20:18
 */
@Service
public class LoginServiceImpl implements LoginService {


    private final String appId = "wxdba73c014e615783";
    private final String appSecret = "123";

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Resource
    private AdminService adminService;

    @Override
    public LoginResponse performLogin(String jsCode) {
        String url = "https://api.weixin.qq.com/sns/jscode2session" +
                "?appid=" + appId +
                "&secret=" + appSecret +
                "&js_code=" + jsCode +
                "&grant_type=authorization_code";

        logger.info(url);

        String resp = HttpUtil.createGet(url).execute().body();
        LoginResponse loginResponse = JSONObject.parseObject(resp, LoginResponse.class);

        if (loginResponse.getErrcode().equals(0)){
            UmsAdmin adminByOpenId = adminService.getAdminByOpenId(loginResponse.getOpenid());
        }

        logger.info(resp);
        return loginResponse;
    }


}
