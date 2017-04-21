package com.kklt.paging.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by root on 17-4-21.
 */
public class JdbcConnectionUtil {
    /**
     * driver 数据库驱动类
     */
    private static String DRIVER;
    /**
     * userName 数据库用户名
     */
    private static String USERNAME;
    /**
     *  password 数据库密码
     */
    private static String PASSWORD;
    /**
     * uri 数据库地址
     */
    private static String URL;

    static {
        //加载配置文件并赋值
        loadProperties();
        //加载数据库连接驱动
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("加载驱动类失败");
        }

    }

    /**
     * 加载配置文件并赋值
     */
    public static void loadProperties(){
        InputStream inputStream = JdbcConnectionUtil.class.getResourceAsStream("/jdbc/jdbc.properties");
        try {
            Properties properties = new Properties();
            properties.load(inputStream);
            setDRIVER(properties.getProperty("jdbc.driver"));
            setUSERNAME(properties.getProperty("jdbc.username"));
            setPASSWORD(properties.getProperty("jdbc.password"));
            setURL(properties.getProperty("jdbc.uri"));
        } catch (IOException e) {
            throw new RuntimeException("加载配置文件的内容失败");
        }
    }

    public static Connection getConnection(){
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("获取数据库连接失败");
        }
        return connection;
    }

    public static String getDRIVER() {
        return DRIVER;
    }

    public static void setDRIVER(String DRIVER) {
        JdbcConnectionUtil.DRIVER = DRIVER;
    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static void setUSERNAME(String USERNAME) {
        JdbcConnectionUtil.USERNAME = USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static void setPASSWORD(String PASSWORD) {
        JdbcConnectionUtil.PASSWORD = PASSWORD;
    }

    public static String getURL() {
        return URL;
    }

    public static void setURL(String URL) {
        JdbcConnectionUtil.URL = URL;
    }
}
