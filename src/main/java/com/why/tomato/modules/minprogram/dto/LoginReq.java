package com.why.tomato.modules.minprogram.dto;

import lombok.Data;

/**
 * @author why
 * @date 2023/8/3 20:13
 */
@Data
public class LoginReq {

    private String appid;

    private String secret;

    private String js_code;

    private String grant_type;

}
