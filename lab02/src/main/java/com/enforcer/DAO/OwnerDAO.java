package com.enforcer.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface OwnerDAO {
    /** Создает новую запись и соответствующий ей объект */
    public Owner create() throws IOException;

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public Owner read(int key) throws SQLException;

    /** Сохраняет состояние объекта group в базе данных */
    public void update(Owner owner, int key);

    /** Удаляет запись об объекте из базы данных */
    public void delete(Owner owner) throws SQLException;

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<Owner> getAll() throws SQLException;
}
