package com.enforcer.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private String user = "root";//Логин пользователя
    private String password = "root";//Пароль пользователя
    private String url = "jdbc:mysql://localhost:3306/lab02";//URL адрес
    private String driver = "com.mysql.jdbc.Driver";//Имя драйвера

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public OwnerDAO getOwnerDao(Connection connection) {
        return new MySQLOwnerDAO(connection);
    }

    public PetDAO getPetDao(Connection connection) {
        return new MySQLPetDAO(connection);
    }

    public static void connectionClose(Connection connection) throws SQLException {
        if (!connection.isClosed()) {
            connection.close();
        }
    }

    public DAO() {
        try {
            Class.forName(driver);//Регистрируем драйвер
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
