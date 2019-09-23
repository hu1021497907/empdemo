package com.neuedu.util;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

    public static final boolean DEFAULT_AUTO_COMMIT = true;

    private static final SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(
            MyBatisUtil.class.getClassLoader().getResourceAsStream("mybatis.xml"));

    public static SqlSession getSqlSession(boolean autoCommit){
        return factory.openSession(autoCommit);
    }

    public static SqlSession getSqlSession(){
        return factory.openSession(DEFAULT_AUTO_COMMIT);
    }

}
