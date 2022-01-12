package xyz.wildx.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import xyz.wildx.commons.response.ResultModel;
import xyz.wildx.entity.WildxUser;
import xyz.wildx.handler.CheckMethod;
import xyz.wildx.service.user.IWildxUserService;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangbo
 * @since 2021-06-09
 */
@Api(value = "用户模块")
@RestController
@RequestMapping("/wildx-user")
public class WildxUserController {
    @Autowired
    private IWildxUserService iWildxUserService;


    @Autowired
    private IWildxUserService wildxUserService;

    @ApiOperation(value = "登录接口")
    @GetMapping("/login")
    @CheckMethod
    public ResultModel login(HttpServletRequest request){
        return wildxUserService.login(request);
    }


    @PostMapping("/register")
    public ResultModel register(@RequestBody WildxUser user) throws IllegalAccessException {

        return wildxUserService.register(user);
    }

}
