package com.enforcer.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLPetDAO implements PetDAO {
    private final Connection connection;

    public MySQLPetDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Pet create() {
        return null;
    }

    @Override
    public Pet read(int key) throws SQLException {
        String query = "select * from pet where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, key);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        Pet pet = new Pet();
        pet.setId(resultSet.getInt("id"));
        pet.setName(resultSet.getString("name"));
        pet.setAge(resultSet.getInt("age"));
        pet.setType(resultSet.getString("type"));
        pet.setPetOwnerId(resultSet.getInt("pet_owner_id"));

        return pet;
    }

    @Override
    public void update(Pet pet) {


    }

    @Override
    public void delete(Pet pet) {
        String query = "delete from pet where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try {
                preparedStatement.setObject(1, pet.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int count = preparedStatement.executeUpdate();
            if (count != 1) {
                throw new SQLException("On delete modify more then one record: " + count);
            }
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Pet> getAll() throws SQLException {
        String query = "select * from pet";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Pet> list = new ArrayList<Pet>();
        Pet pet = new Pet();

        while (resultSet.next()){
            pet.setId(resultSet.getInt("id"));
            pet.setName(resultSet.getString("name"));
            pet.setAge(resultSet.getInt("age"));
            pet.setType(resultSet.getString("type"));
            pet.setPetOwnerId(resultSet.getInt("pet_owner_id"));

            list.add(pet);
        }
        return list;
    }
}
