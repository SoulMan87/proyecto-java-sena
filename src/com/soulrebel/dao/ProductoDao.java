package com.soulrebel.dao;

import com.soulrebel.model.Producto;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

public interface ProductoDao {

    boolean insertarProducto(Producto producto) throws SQLException;

    List<Producto> listarProductos() throws SQLException;

    boolean eliminarProducto(Producto producto) throws SQLException;

    boolean actualizarProducto(Producto producto) throws SQLException;

    Producto optenerProductoPorId(int id) throws SQLException;
}
