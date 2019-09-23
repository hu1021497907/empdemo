package com.neuedu.service.impl;

import com.neuedu.entity.Emp;
import com.neuedu.mapper.EmpMapper;
import com.neuedu.service.EmpService;
import com.neuedu.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    @Override
    public List<Emp> listEmp() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = empMapper.listEmp();
        sqlSession.close();
        return empList;
    }

    @Override
    public List<Emp> listEmpDept() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = empMapper.listEmpDept();
        sqlSession.close();
        return empList;
    }

    @Override
    public int saveEmp(Emp emp) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        int row = empMapper.saveEmp(emp);
        sqlSession.close();
        return row;
    }

    @Override
    public int deleteEmpById(Integer id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        int row = empMapper.deleteEmpById(id);
        sqlSession.close();
        return row;
    }

    @Override
    public Emp getEmpById(Integer id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.getEmpById(id);
        sqlSession.close();
        return emp;
    }

    @Override
    public int updateEmpById(Emp emp) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        int row = empMapper.updateEmpById(emp);
        sqlSession.close();
        return row;
    }
}
