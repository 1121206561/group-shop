package cn.youxu.shop.Interceptor;

import cn.youxu.shop.annotation.FilterFrom;
import cn.youxu.shop.common.CommonResponse;
import cn.youxu.shop.utils.JWTUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拦截器拦截进行token验证
 */
public class JwtHandlerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //设置跨域
        setHeader(request, response);
        //如果是options类型的请求直接放行
        if (request.getMethod().equals(RequestMethod.OPTIONS.name())) {

            return true;
        }
        //设置跨域--结束
        //拦截获取添加在适配器上的注解，判断是否有添加的放行注解
        HandlerMethod method = (HandlerMethod) handler;
        FilterFrom filterFrom = method.getMethodAnnotation(FilterFrom.class);
        /**
         * 添加了filterfrom注解就进行登录验证
         * 请求的方法可以有注解，也可以没有，有注解的情况下，进行判断值，如果是没注解的情况下呢，
         *  没注解就直接拦截，禁止请求。
         *  解决办法：(自定义一个方法，返回boolean方法，获取token的方法。）
         */
        //获取添加在方法上的注解，判断是否存在放行注解
        if (filterFrom != null && filterFrom.value()) {
            //如果设置放行注解为true，就直接放行
            return true;
        }
        //没添加注解，进行返回提示
        return doFilter(request, response);
    }

    public boolean doFilter(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        //默认为false，拦截获取token
        String token = null;
        String username = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("Admin-Token")) {
                token = cookie.getValue();
                username = JWTUtil.verifyToken(token);
            }
        }
        if (StringUtils.isNotBlank(token) && StringUtils.isNotBlank(username)){
            return true;
        } else{
            response.getWriter().print(JSONObject.toJSONString(CommonResponse.error().message("您还没有登录，请登陆")));
            return false;
        }
    }

    /**
     * 为response设置header，实现跨域
     */
    private void setHeader(HttpServletRequest request, HttpServletResponse response) {
        //跨域的header设置
        response.setHeader("Access-control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", request.getMethod());
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
        //防止乱码，适用于传输JSON数据
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
    }
}
