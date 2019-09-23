package com.neuedu.filter;


import com.neuedu.entity.User;
import com.neuedu.service.impl.UserService;
import com.neuedu.service.impl.UserServiceImpl;
import com.neuedu.util.CookieUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebFilter(urlPatterns = {"/*"})
public class LoginFilter implements Filter {

    UserService userService =new UserServiceImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {



    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1.判断此人是否登录
        //从Session中去user
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        if (uri.equals("/loginview") || uri.equals("/login") || uri.endsWith(".js") || uri.endsWith(".css")) {
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            HttpSession httpSession = request.getSession();
            User user = (User) httpSession.getAttribute("user");
            //判断是否登录
            if (user == null){
                Cookie[] cookies = request.getCookies();
                Map<String, String> map = CookieUtils.cookiesToMap(cookies);
                String value = map.get("username");
                if (value == null) {
                    //未登录
                    response.sendRedirect("loginview");
                } else {
                    User userCookie = userService.getUserByUsername(value);
                    httpSession.setAttribute("user", userCookie);
                    filterChain.doFilter(servletRequest,servletResponse);
                }

            }else {
                //登录放行
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }




    }

    @Override
    public void destroy() {

    }
}
