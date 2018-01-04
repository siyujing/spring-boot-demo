package com.testingedu.jdbcdemo.domain.dao;

import lombok.Data;
import org.slf4j.LoggerFactory;

import java.sql.*;

@Data
public class BaseDao {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseDao.class);

    //连接数据库
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/syj";
    static String user = "root";
    static String password = "";

    //对象
    public static Connection connection = null;
    public static Statement stmt = null;
    public static PreparedStatement pstmt = null;
    public static ResultSet rs = null;
    public static CallableStatement cs = null;

    public static void getJDBCConnection() {

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            logger.info("驱动异常",e);
        }finally {
//            closeAll();
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            logger.info("连接异常",e);
        }finally {
//            closeAll();
        }
    }

    //释放资源
    public static void closeAll(){

        try {
            if(cs!=null){
                cs.close();
            }
            if(rs!=null){
                rs.close();
            }
            if(stmt!=null){
                stmt.close();
            }
            if(pstmt!=null){
                pstmt.close();
            }
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("释放资源异常！");
        }

    }
}
