package com.example.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;

public class DBUtils {
    private static SqlSessionFactory sqlSessionFactory;
    /**
     * 在静态代码块中初始化工厂
     */
    static{
        //先查找mybatis的核心配置文件来初始化数据源，
        //默认从classpath下查找核心配置文件
        try {
            //注意：import org.apache.ibatis.io.Resources;
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            //创建一个SqlSessionFactoryBuilder来解析配置文件的信息，
            // 然后创建出SqlSessionFactory实例
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //build方法传入一个输入流，通过解析后返回一个SqlSessionFactory实例
            sqlSessionFactory = builder.build(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提供一个获取SqlSession的方法
     * @param autoCommit 在获取SQL Session时可以传递一个boolean类型的参数值，
     *             这个参数的作用似乎用于设置是否手动提交事务还是自动提交事务，
     *             false为手动提交，true为自动提交
     * @return
     */
    public static SqlSession getSqlSession(boolean autoCommit){
        //通过openSession方法来创建一个sqlSession实例，
        //有了SqlSession，就可以来访问数据库
        return sqlSessionFactory.openSession(autoCommit);
    }
}
