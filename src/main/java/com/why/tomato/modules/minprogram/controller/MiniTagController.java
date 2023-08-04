package com.why.tomato.modules.minprogram.controller;

import com.why.tomato.common.api.CommonResult;
import com.why.tomato.modules.ums.model.UmsAdmin;
import com.why.tomato.modules.ums.service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author why
 * @date 2023/8/4 15:36
 */
@RestController("/mini")
public class MiniTagController {


    @Resource
    AdminService adminService;


    @GetMapping("/list")
    public CommonResult<List<UmsAdmin>> list(){
        List<UmsAdmin> list = adminService.list();
        return CommonResult.success(list);

    }


}
