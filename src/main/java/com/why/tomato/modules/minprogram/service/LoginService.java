package com.why.tomato.modules.minprogram.service;

import com.why.tomato.modules.minprogram.dto.LoginResponse;

/**
 * @author why
 * @date 2023/8/3 20:17
 */
public interface LoginService {

    LoginResponse performLogin(String jsCode);

}
