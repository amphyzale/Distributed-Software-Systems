package com.enfor.myapp.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
//                Properties properties = new Properties();
//                InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("/resources/application.properties");
  //              properties.load(inputStream);
//                String driver = properties.getProperty("db.driver");
//                String url = properties.getProperty("db.url");
//                String user = properties.getProperty("db.username");
//                String password = properties.getProperty("db.password");
                String user = "root";//Логин пользователя
                String password = "root";//Пароль пользователя
                String url = "jdbc:mysql://localhost:3306/lab02";//URL адрес
                String driver = "com.mysql.jdbc.Driver";//Имя драйвера
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
                System.out.println(connection == null);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } //catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            return connection;
        }

    }
}
