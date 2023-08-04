package com.why.tomato.mini;

import com.alibaba.fastjson2.JSONObject;
import com.why.tomato.modules.minprogram.dto.LoginResponse;
import com.why.tomato.modules.minprogram.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author why
 * @date 2023/8/4 11:55
 */
@SpringBootTest
public class Login {

    @Autowired
    LoginService loginService;

    @Test
    public void miniLogin(){

        LoginResponse code = loginService.performLogin("code");
//
////        LoginResponse loginResponse = JSONObject.parseObject(code, LoginResponse.class);
//
//        System.out.println(JSONObject.toJSONString(loginResponse));
//        assert loginResponse.getErrcode().equals(40029);
        return;

    }


}
