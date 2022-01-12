package xyz.wildx.commons.constants;

import org.springframework.http.HttpHeaders;

/**
 * wildx constants.
 *
 * @author wangbo
 * @date 2021/6/13
 */
public class WildxConst {

    public static final String URL_SEPARATOR = "/";

    public static final String PROTOCOL_HTTP = "http://";

    public static final String PROTOCOL_HTTPS = "https://";
    /**
     * Admin token header name.
     */
    public static final String ADMIN_TOKEN_HEADER_NAME = "ADMIN-" + HttpHeaders.AUTHORIZATION;
    /**
     * Content token header name.
     */
    public static final String API_ACCESS_KEY_HEADER_NAME = "API-" + HttpHeaders.AUTHORIZATION;
}
