package com.neuedu.service;

import com.neuedu.entity.Emp;

import java.util.List;

public interface EmpService {

    List<Emp> listEmp();

    List<Emp> listEmpDept();

    int saveEmp(Emp emp);

    int deleteEmpById(Integer id);

    Emp getEmpById(Integer id);

    int updateEmpById(Emp emp);
}
