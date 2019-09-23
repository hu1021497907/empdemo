package com.neuedu.service.impl;

import com.neuedu.entity.Dept;
import com.neuedu.mapper.DeptMapper;
import com.neuedu.service.DeptService;
import com.neuedu.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DeptServiceImpl implements DeptService {
    @Override
    public List<Dept> listDept() {

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> deptList = deptMapper.listDept();
        sqlSession.close();
        return deptList;
    }
}
