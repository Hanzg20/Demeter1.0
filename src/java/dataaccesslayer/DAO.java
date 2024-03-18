/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author hanzg
 */
public interface DAO<T> {

    /**
     * Inserts a new record into the database.
     *
     * @param t The object to insert.
     * @return The number of rows affected (1 if successful, 0 otherwise).
     */
    public int insert(T t);

    /**
     * Deletes a record from the database by its ID.
     *
     * @param id The ID of the record to delete.
     * @return The number of rows affected (1 if successful, 0 otherwise).
     */
    public int delete(Serializable id);

    /**
     * Updates an existing record in the database.
     *
     * @param t The object with updated information.
     * @return The number of rows affected (1 if successful, 0 otherwise).
     */
    public int update(T t);

    /**
     * Finds a record in the database by its ID.
     *
     * @param id The ID of the record to find.
     * @return The record object if found, null otherwise.
     */
    public T findById(Serializable id);

    /**
     * Retrieves all records from the database.
     *
     * @return A list of all record objects in the database.
     */
    public List<T> findAll();
}
