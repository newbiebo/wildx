package xyz.wildx.service.user.impl;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Base64Utils;
import org.springframework.util.DigestUtils;
import xyz.wildx.commons.response.ResultModel;
import xyz.wildx.commons.utils.JsonUtils;
import xyz.wildx.entity.WildxUser;
import xyz.wildx.enums.ResponseCode;
import xyz.wildx.mapper.WildxUserMapper;
import xyz.wildx.service.user.IWildxUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangbo
 * @since 2021-06-09
 */
@Service
public class WildxUserServiceImpl extends ServiceImpl<WildxUserMapper, WildxUser> implements IWildxUserService {

    @Value("${jwt.key}")
    private String key;

    @Override
    public ResultModel login(HttpServletRequest request) {
        String token = request.getHeader("token");
        String s = "456";
        System.out.println(s);
        //md5加密
        System.out.println(DigestUtils.md5DigestAsHex(s.getBytes()));
        return ResultModel.failed();
    }

    @Override
    public ResultModel register(WildxUser user) {
        WildxUser one = this.getOne(new QueryWrapper<WildxUser>().lambda()
                .eq(user.getUserName() != null, WildxUser::getUserName, user.getUserName())
                .eq(user.getNick() != null, WildxUser::getNick, user.getNick()));
        if (one != null) {
            return ResultModel.failed("该用户已经存在");
        }
        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");
        long time = System.currentTimeMillis() + 30 * 60 * 1000;
        Date date = new Date(time);
        String jwt = JWT.create()
                .withHeader(header)  // header段，带有算法信息和类型信息
                .withExpiresAt(date) // payload段，设置过期时间
                .withIssuedAt(new Date()) //payload段，设置签发时间
                .withIssuer("MoSen")// payload段，设置签发者
                .withClaim("userIp", user.getUserIp())
                .withClaim("name", user.getUserName())
                .withClaim("nick", user.getNick())
                .withClaim("mail", user.getMail())
                .withClaim("age", user.getAge())
                .withClaim("birthday", user.getBirthday())
                .withClaim("mobile", user.getMobile())
                .sign(Algorithm.HMAC256(key));// signature段，进行加盐加密

        System.out.println(jwt);
        this.saveOrUpdate(user);
        return ResultModel.success(jwt);
    }
}
