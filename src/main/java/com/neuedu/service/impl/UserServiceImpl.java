package com.neuedu.service.impl;

import com.neuedu.entity.User;
import com.neuedu.mapper.UserMapper;
import com.neuedu.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {
    @Override
    public User getUserByUsername(String username) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByUsername(username);
        sqlSession.close();
        return user;
    }
}
