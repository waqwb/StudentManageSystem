package cn.tedu.mytest;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Classname MyTest
 * @Description TODO
 * @Date 2022/12/10 23:13
 * @Created by Administrator
 */
public class MyTest {
    @Test
    public void test01() {
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Test";
        String userName = "sa";
        String userPwd = "qwerty";
        Connection dbConn = null;
        try {
            Class.forName(driverName);
            dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("连接数据库成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("连接失败");
        }
    }

    @Test
    public void test02() throws IOException, ClassNotFoundException, SQLException {
        //1.读取配置文件中的4个基本信息
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(is);

        String user = properties.getProperty("username");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");
        System.out.println(user + password + url + driverClass);
        //2.加载驱动
        Class.forName(driverClass);
        //3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
}
