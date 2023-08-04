package com.why.tomato.modules.minprogram.controller;

import com.why.tomato.common.api.CommonResult;
import com.why.tomato.modules.minprogram.dto.LoginResponse;
import com.why.tomato.modules.minprogram.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author why
 * @date 2023/8/3 20:08
 */
@RestController
@RequestMapping("/mini")
public class MiniLoginController {


    @Autowired
    private LoginService loginService;


    @GetMapping("/login")
    public CommonResult<LoginResponse> login(@RequestParam String code) {

        LoginResponse loginResponse = loginService.performLogin(code);
        if (loginResponse.getErrcode() == 0){
            return CommonResult.success(loginResponse);
        }else {
            return CommonResult.failed(loginResponse.getErrmsg());
        }
    }




}
