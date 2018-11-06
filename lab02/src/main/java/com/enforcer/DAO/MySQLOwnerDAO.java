package com.enforcer.DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MySQLOwnerDAO implements OwnerDAO{
    private final Connection connection;

    public MySQLOwnerDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Owner create() throws IOException {
        Owner owner = new Owner();
        String query = "insert into owner (`name`, `birthDate`, `address`, `iq`) values (?, ?, ?, ?)";
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
//
//            System.out.println("Input Name: ");
//            owner.setName(reader.readLine());
//            System.out.println("Input Birthday like YYYY-MM-DD: ");
//            owner.setBirthDate(reader.readLine());
//            System.out.println("Input Address");
//            owner.setAddress(reader.readLine());
//            System.out.println("Input IQ");
//            owner.setIq(Integer.parseInt(reader.readLine()));

            owner.setName("LastName");
            owner.setBirthDate("1999-01-10");
            owner.setAddress("LastAddress");
            owner.setIq(150);
            //java.sql.Date sqlDate = new java.sql.Date(owner.getBirthDate());
            preparedStatement.setString(1, owner.getName());
            preparedStatement.setDate(2, new java.sql.Date(owner.getBirthDate().getTime()));
            preparedStatement.setString(3, owner.getAddress());
            preparedStatement.setInt(4, owner.getIq());

            if (preparedStatement.executeUpdate() > 0) {
                OwnerDAO ownerDAO = new DAO().getOwnerDao(connection);
                System.out.println("Owner was create with id: " +
                        (int) (ownerDAO.getAll().get(ownerDAO.getAll().size() - 1)).getId());
                return owner;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Owner read(int key) throws SQLException {
        String query = "select * from owner where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, key);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        Owner owner = new Owner();
        owner.setId(resultSet.getInt("id"));
        owner.setName(resultSet.getString("name"));
        owner.setBirthDate(resultSet.getDate("birthDate").toString());
        owner.setAddress(resultSet.getString("address"));
        owner.setIq(resultSet.getInt("iq"));

        return owner;
    }

    @Override
    public void update(Owner owner, int key) {
        String name = owner.getName();
        String query = "update owner set `name` = ?, `birthDate` = ?, `address` = ?, `iq` = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, owner.getName());
            preparedStatement.setDate(2, new java.sql.Date(owner.getBirthDate().getTime()));
            preparedStatement.setString(3, owner.getAddress());
            preparedStatement.setInt(4, owner.getIq());
            preparedStatement.setInt(5, key);

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Owner was changed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Owner owner) throws SQLException {
        String query = "delete from owner where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try {
                preparedStatement.setObject(1, owner.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int count = preparedStatement.executeUpdate();
            if (count != 1) {
                throw new SQLException("On delete modify more then 1 record: " + count);
            }
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Owner> getAll() throws SQLException {
        String query = "select * from owner";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Owner> list = new ArrayList<Owner>();
        Owner owner = new Owner();

        while (resultSet.next()){
            owner.setId(resultSet.getInt("id"));
            owner.setName(resultSet.getString("name"));
            owner.setBirthDate(resultSet.getDate("birthDate").toString());
            owner.setAddress(resultSet.getString("address"));
            owner.setIq(resultSet.getInt("iq"));

            list.add(owner);
        }
        return list;
    }
}
