package com.suzhou.myleesite.modules.sys.interceptor;

import com.suzhou.myleesite.common.UserAgentUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器（ pc 端与 mobile 端）
 * @author:suzhou
 * @Date: 2018-01-12
 * @Time: 下午 4:08
 */
public class MobileInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        // pc 端

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        if(modelAndView != null){
            //是 移动 端
            if(UserAgentUtils.isMobileOrTablet(httpServletRequest)&&!StringUtils.startsWithIgnoreCase(modelAndView.getViewName(), "redirect:")){
                System.out.println(httpServletRequest.getHeader("User-Agent"));

                modelAndView.setViewName("mobile"+modelAndView.getViewName().replace("modules",""));
            }

        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
