package com.neuedu.servlet;

import com.neuedu.entity.Emp;
import com.neuedu.service.EmpService;
import com.neuedu.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/emplist"})
public class EmpListServlet extends HttpServlet {

    private EmpService empService = new EmpServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.查询数据库
        List<Emp> empList = empService.listEmpDept();
        System.out.println(empList);
        //2.把数据库绑定到req对象上
        req.setAttribute("empList",empList);
        //3.转发到jsp上
        req.getRequestDispatcher("/WEB-INF/pages/emplist.jsp").forward(req,resp);
    }
}
