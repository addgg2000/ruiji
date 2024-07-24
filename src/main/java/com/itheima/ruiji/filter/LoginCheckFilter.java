package com.itheima.ruiji.filter;

import cn.hutool.core.text.AntPathMatcher;
import com.alibaba.fastjson.JSON;
import com.itheima.ruiji.common.BaseContext;
import com.itheima.ruiji.common.R;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查用户是否登录
 */
@Slf4j
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    public static  final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**"
        };
        boolean check = check(urls,httpServletRequest.getRequestURI());
        if(check){
            chain.doFilter(request, response);
            return;
        }
        //4.判断登录状态 如果已登录 则直接放行
        if(((HttpServletRequest) request).getSession().getAttribute("employee") != null){
            Long empId = (Long) ((HttpServletRequest) request).getSession().getAttribute("employee");
            BaseContext.setCurrentId(empId);
            chain.doFilter(request,response);
            return;
        }
        //通過輸出流向客户端响应数据
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;
    }

    /**
     *
     * @param requestURI
     * @return
     */
    public boolean check(String[] urls,String requestURI){
        for(String url : urls){
            boolean match =PATH_MATCHER.match(url,requestURI);
            if(match){
                return true;
            }
        }
        return false;

    }
}
