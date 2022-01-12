package xyz.wildx.service.user;

import org.springframework.web.bind.annotation.RequestBody;
import xyz.wildx.commons.response.ResultModel;
import xyz.wildx.entity.WildxUser;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangbo
 * @since 2021-06-09
 */
public interface IWildxUserService extends IService<WildxUser> {

    ResultModel login(HttpServletRequest request);

    ResultModel register(WildxUser user) throws IllegalAccessException;

}
