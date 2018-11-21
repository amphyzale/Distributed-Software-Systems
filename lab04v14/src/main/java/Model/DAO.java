package Model;

import Entity.Owner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    Connection connection;
    String URL;
    String Username;
    String Password;

    public DAO(String URL, String Username, String Password) {
        this.URL = URL;
        this.Username = Username;
        this.Password = Password;
    }

    protected void Connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                //throw new SQLException(e);
            }
            connection = DriverManager.getConnection(URL, Username, Password);
        }
    }

    protected void Disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public boolean create(Owner owner) throws SQLException {
        Connect();
        String query = "insert into owner (`name`, `birthDate`, `address`, `iq`) values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, owner.getName());
        preparedStatement.setDate(2, new Date(owner.getBirthDate().getTime()));
        preparedStatement.setString(3, owner.getAddress());
        preparedStatement.setInt(4, owner.getIq());
        boolean rowInserted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        Disconnect();
        return rowInserted;
    }

    public List<Owner> listAllOwners() throws SQLException {
        List<Owner> listOwners = new ArrayList<>();
        String query = "select * from owner";
        Connect();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery(query);
        while (resultSet.next()) {
            Owner owner = new Owner();
            owner.setId(resultSet.getInt("id"));
            owner.setName(resultSet.getString("name"));
            owner.setBirthDate(resultSet.getDate("birthDate").toString());
            owner.setAddress(resultSet.getString("address"));
            owner.setIq(resultSet.getInt("iq"));

            listOwners.add(owner);
        }
        resultSet.close();
        preparedStatement.close();
        Disconnect();
        return listOwners;
    }

    public boolean deleteOwner(Owner owner) throws SQLException {
        String query = "delete from owner where id = ?";
        Connect();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, owner.getId());
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        Disconnect();
        return rowDeleted;
    }

    public boolean updateOwner(Owner owner) throws SQLException {
        String query = "update owner set `name` = ?, `birthDate` = ?, `address` = ?, `iq` = ? where id = ?";
        Connect();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, owner.getName());
        preparedStatement.setDate(2, new Date(owner.getBirthDate().getTime()));
        preparedStatement.setString(3, owner.getAddress());
        preparedStatement.setInt(4, owner.getIq());
        preparedStatement.setLong(5, owner.getId());
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        Disconnect();
        return rowUpdated;
    }

    public Owner getOwner(int id) throws SQLException {
        Owner owner = new Owner();
        String query = "select * from owner where id = ?";
        Connect();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            owner.setId(resultSet.getInt("id"));
            owner.setName(resultSet.getString("name"));
            owner.setBirthDate(resultSet.getDate("birthDate").toString());
            owner.setAddress(resultSet.getString("address"));
            owner.setIq(resultSet.getInt("iq"));

        }
        resultSet.close();
        preparedStatement.close();
        return owner;
    }
}

