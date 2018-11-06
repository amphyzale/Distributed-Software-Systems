package com.enforcer.DAO;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class MySQLOwnerDAOTest {

    @Test
    public void getAll() throws SQLException {
        DAO dao = new DAO();
        List<Owner> list;
        try (Connection connection = dao.getConnection()) {
            OwnerDAO ownerDAO = dao.getOwnerDao(connection);
            list = ownerDAO.getAll();
        }
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void create() throws SQLException, IOException {
        Owner owner;
        try (Connection connection = new DAO().getConnection()){
            OwnerDAO ownerDAO = new DAO().getOwnerDao(connection);
            owner = ownerDAO.create();
        }
        Assert.assertNotNull(owner);
        System.out.println(owner.getBirthDate());
    }

    @Test
    public void read() throws SQLException {
        DAO dao = new DAO();
        Owner owner;
        try (Connection connection = dao.getConnection()){
            OwnerDAO ownerDAO = dao.getOwnerDao(connection);
            owner = ownerDAO.read(1);
        }
        Assert.assertNotNull(owner);

    }

    @Test
    public void update() throws SQLException {
        Owner owner = new Owner();
        owner.setName("NewName");
        owner.setBirthDate("2000-01-01");
        owner.setAddress("NewAddress");
        owner.setIq(200);
        try (Connection connection = new DAO().getConnection()) {
            OwnerDAO ownerDAO = new DAO().getOwnerDao(connection);
            ownerDAO.update(owner, 12);
        }
        Connection connection = new DAO().getConnection();
        OwnerDAO ownerDAO = new DAO().getOwnerDao(connection);
        Assert.assertEquals(owner.getName(), ownerDAO.read((int) (ownerDAO.getAll().get(ownerDAO.getAll().size() - 1)).getId()).getName());
    }

    @Test
    public void delete() throws SQLException {
        DAO dao = new DAO();
        Owner owner;
        try (Connection connection = dao.getConnection()){
            OwnerDAO ownerDAO = dao.getOwnerDao(connection);
            owner = ownerDAO.read((int) (ownerDAO.getAll().get(ownerDAO.getAll().size() - 1)).getId());
            ownerDAO.delete(owner);
        }
        Assert.assertNotNull("Owner not found.", owner);
    }
}