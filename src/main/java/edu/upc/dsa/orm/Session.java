package edu.upc.dsa.orm;


import java.util.HashMap;
import java.util.List;

public interface Session<E> {
    int save(Object entity);                                           // Crud
    void close();
    Object get(Class theClass, Object ID);
    Object getbyName(Class theClass, Object ID);// cRud
    void update(Object object);                                         // crUd
    void delete(Object object);                                         // cruD
    List<Object> findAll(Class theClass);                               // cR
    List<Object> findAll(Class theClass, HashMap params);
    List<Object> query(String query, Class theClass, HashMap params);
}
