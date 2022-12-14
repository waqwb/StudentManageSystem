package cn.waqwb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Classname DBUtils
 * @Description TODO
 * @Date 2022/12/14 23:32:19
 * @Created by Administrator
 */
public class DBUtils {
    //定义一个获得数据库连接的一个方法
    public static Connection getCon() throws SQLException{
//        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Test";
        String userName = "sa";
        String userPwd = "qwerty";
//        Class.forName(driverName);
        Connection conn = DriverManager.getConnection(dbURL,userName,userPwd);
        return conn;
    }
}
