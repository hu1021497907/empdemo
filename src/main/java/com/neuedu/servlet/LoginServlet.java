package com.neuedu.servlet;

import com.google.gson.Gson;
import com.neuedu.entity.User;
import com.neuedu.service.impl.UserService;
import com.neuedu.service.impl.UserServiceImpl;
import com.neuedu.vo.LoginVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();


        //1.从表单中获取输入的用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2.通过用户名查询用
        User user = userService.getUserByUsername(username);
        if (user != null){
            if (user.getPassword().equals(password)){
                HttpSession httpSession = req.getSession();
                //登录成功将信息存储到Session中
                httpSession.setAttribute("user",user);
                Cookie cookie = new Cookie("username",user.getPassword());
                cookie.setMaxAge(60 * 60 * 24);
                resp.addCookie(cookie);
//                resp.sendRedirect("emplist");
                LoginVo loginVo = LoginVo.success();
                String jsonStr = new Gson().toJson(loginVo);
                out.print(jsonStr);
            } else {
                //密码错误
                LoginVo loginVo = LoginVo.error(1,"密码错误");
                String jsonStr = new Gson().toJson(loginVo);
                out.print(jsonStr);
            }

        }else {
            //用户名不存在
//            resp.sendRedirect("loginview");
            LoginVo loginVo = LoginVo.error(2,"用户名不存在");
            String jsonStr = new Gson().toJson(loginVo);
            out.print(jsonStr);
        }


    }
}
