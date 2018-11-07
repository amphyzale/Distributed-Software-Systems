package com.enforcer.DAO;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class MySQLPetDAOTest {

    @Test
    public void create() throws SQLException, IOException {
        Pet pet;
        try (Connection connection = new DAO().getConnection()){
            PetDAO petDAO = new DAO().getPetDao(connection);
            pet = petDAO.create();
        }
        Assert.assertNotNull(pet);
    }

    @Test
    public void read() throws SQLException {
        DAO dao = new DAO();
        Pet pet;
        try (Connection connection = dao.getConnection()) {
            PetDAO petDAO = dao.getPetDao(connection);
            pet = petDAO.read(1);
        }
        Assert.assertNotNull(pet);
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() throws SQLException {
        DAO dao = new DAO();
        Pet pet;
        try (Connection connection = dao.getConnection()){
            PetDAO petDAO = dao.getPetDao(connection);
            pet = petDAO.read((int) (petDAO.getAll().get(petDAO.getAll().size() - 1)).getId());
            petDAO.delete(pet);
        }
        Assert.assertNotNull("Pet not found.", pet);
    }

    @Test
    public void getAll() throws SQLException {
        DAO dao = new DAO();
        List<Pet> list;
        try (Connection connection = dao.getConnection()){
            PetDAO petDAO = dao.getPetDao(connection);
            list = petDAO.getAll();
        }
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
    }
}