package xyz.wildx;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * wildx main class.
 *
 * @author newbiebo
 * @date 2021-6-6
 */
@Slf4j
@SpringBootApplication
@EnableSwagger2
@MapperScan("xyz.wildx.mapper")
public class WildxApplication {
    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(WildxApplication.class);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        log.info("\n----------------------------------------------------------\n\t"
                //启动成功
                + "博客系统启动成功! 访问地址如下:\n\t"
                //
                + "访问路径: \thttp://" + ip + ":" + port + path + "/\n\t"
                //
                + "接口文档: \thttp://" + ip + ":" + port + path + "/swagger-ui.html\n"
                //
                + "----------------------------------------------------------");
    }
}
