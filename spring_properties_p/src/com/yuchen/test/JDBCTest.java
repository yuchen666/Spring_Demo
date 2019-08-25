package com.yuchen.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] args) {
        /***
         * 获取spring.xml配置
         */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        /***
         * 创建DataSource对象
         */
        DataSource ds = (DataSource)applicationContext.getBean("dataSource");
        Connection conn = null;
        try {
            /***
             * 链接数据库
             */
            conn = ds.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("conn = " + conn);
    }
}
