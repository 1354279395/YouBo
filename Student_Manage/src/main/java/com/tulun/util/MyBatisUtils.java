package com.tulun.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * description：
 *
 * @author ajie
 * data 2018/11/5 9:45
 */
public class MyBatisUtils {
    private static SqlSessionFactory ssf;

    static{
        String configFile = "mybatis.xml";
        InputStream in = MyBatisUtils.class.getClassLoader().getResourceAsStream(configFile);
        ssf = new SqlSessionFactoryBuilder().build(in);
    }

    /**
     * MyBatisUtils.getSession
     * @return
     */
    public static SqlSession getSession()
    {
        return ssf.openSession();
    }
}
