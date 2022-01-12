package xyz.wildx.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Admin controller.
 *
 * @author wangbo
 * @date 2021-06-06
 */
@Slf4j
@Api(value = "管理员模块")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @ApiOperation(value = "后台管理员登录接口")
    @PostMapping("/login")
    public String adminlogin(){
        return "王波大傻子";
    }
}
