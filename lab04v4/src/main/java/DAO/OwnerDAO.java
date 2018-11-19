package main.java.DAO;


import main.java.model.Owner;
import main.java.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OwnerDAO {
    private Connection connection;

    public OwnerDAO() {
        connection = DbUtil.getConnection();
    }

    public void addOwner(Owner owner) {
        try {
            String query = "insert into owner(name, birthDate ,address ,iq) values (?, ?, ?, ? )";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // Parameters start with 1
            preparedStatement.setString(1, owner.getName());
            preparedStatement.setDate(2, new java.sql.Date(owner.getBirthDate().getTime()));
            preparedStatement.setString(3, owner.getAddress());
            preparedStatement.setInt(4, owner.getIq());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOwner(int id) {
        String query = "delete from owner where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // Parameters start with 1
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOwner(Owner owner) {
        String query = "update owner set `name` = ?, `birthDate` = ?, `address` = ?, `iq` = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // Parameters start with 1
            preparedStatement.setString(1, owner.getName());
            preparedStatement.setDate(2, new java.sql.Date(owner.getBirthDate().getTime()));
            preparedStatement.setString(3, owner.getAddress());
            preparedStatement.setInt(4, owner.getIq());
            preparedStatement.setLong(5, owner.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Owner> getAllOwners() {
        ArrayList<Owner> listOfOwners = new ArrayList<Owner>();
        String query = "select * from owner";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            Owner owner = new Owner();
            while (resultSet.next()) {
                owner.setId(resultSet.getInt("id"));
                owner.setName(resultSet.getString("name"));
                owner.setBirthDate(resultSet.getDate("birthDate").toString());
                owner.setAddress(resultSet.getString("address"));
                owner.setIq(resultSet.getInt("iq"));

                listOfOwners.add(owner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listOfOwners;
    }

    public Owner getOwnerById(long id) {
        Owner owner = new Owner();
        String query = "select * from owner where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                owner.setId(resultSet.getInt("id"));
                owner.setName(resultSet.getString("name"));
                owner.setBirthDate(resultSet.getDate("birthDate").toString());
                owner.setAddress(resultSet.getString("address"));
                owner.setIq(resultSet.getInt("iq"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return owner;
    }
}
