package com.enforcer.DAO;

import java.sql.SQLException;
import java.util.List;

public interface PetDAO {
    /** Создает новую запись и соответствующий ей объект */
    public Pet create();

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public Pet read(int key) throws SQLException;

    /** Сохраняет состояние объекта group в базе данных */
    public void update(Pet pet);

    /** Удаляет запись об объекте из базы данных */
    public void delete(Pet pet);

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<Pet> getAll() throws SQLException;
}
