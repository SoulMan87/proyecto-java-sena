package com.soulrebel.dao;

import com.soulrebel.model.Cliente;

import java.sql.SQLException;
import java.util.List;

public interface ClienteDao {

    boolean insertar(Cliente cliente) throws SQLException;

    List<Cliente> listarClientes() throws SQLException;

    Cliente optenerClientePorId(int id) throws SQLException;

    boolean actualizar(Cliente cliente) throws SQLException;

    boolean eliminar(Cliente cliente) throws SQLException;
}
