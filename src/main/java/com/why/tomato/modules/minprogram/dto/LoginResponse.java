package com.why.tomato.modules.minprogram.dto;

import lombok.Data;

/**
 * @author why
 * @date 2023/8/3 20:11
 *
 * 小程序登录返回
 */
@Data
public class LoginResponse {

    private String openid;

    private String session_key;

    private String unionid;

    private Integer errcode;

    private String errmsg;

}
