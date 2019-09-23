package com.neuedu.servlet;

import com.neuedu.entity.Dept;
import com.neuedu.entity.Emp;
import com.neuedu.service.DeptService;
import com.neuedu.service.EmpService;
import com.neuedu.service.impl.DeptServiceImpl;
import com.neuedu.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/updateempview"})
public class UpdateEmpViewServlet extends HttpServlet {

    private EmpService empService =new EmpServiceImpl();

    private DeptService deptService = new DeptServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.获取id
        Integer empId = Integer.parseInt(req.getParameter("id"));
        //2.根据数据查询id
        Emp emp = empService.getEmpById(empId);
        //3.绑定到req对象
        req.setAttribute("emp",emp);
        //再绑定所有部门数据
        List<Dept> deptList = deptService.listDept();
        req.setAttribute("deptList",deptList);
        //4.转发到修改页
        req.getRequestDispatcher("/WEB-INF/pages/updateemp.jsp").forward(req,resp);
    }
}
