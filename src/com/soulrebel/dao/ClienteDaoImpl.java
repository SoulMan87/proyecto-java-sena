package com.soulrebel.dao;

import com.soulrebel.model.Cliente;
import com.soulrebel.model.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao {
    private Conexion con;
    private Connection connection;

    public ClienteDaoImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }

    @Override
    public boolean insertar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (id,nombre, apellido, correo, celular) VALUES (?, ?, ?,?,)";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, null);
        statement.setString(2, cliente.getNombre());
        statement.setString(3, cliente.getApellido());
        statement.setString(4, cliente.getCorreo());
        statement.setString(5, cliente.getCelular());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }

    @Override
    public List<Cliente> listarClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM clientes";
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");
            String correo = resultSet.getString("correo");
            String celular = resultSet.getString("celular");
            Cliente cliente = new Cliente(id, nombre, apellido, correo, celular);
            clientes.add(cliente);
        }
        con.desconectar();
        return clientes;
    }

    @Override
    public Cliente optenerClientePorId(int id) throws SQLException {
        Cliente cliente = null;
        String query = "SELECT * FROM cliente WHERE id=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            cliente = new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
                    rs.getString("correo"), rs.getString("celular"));
        }
        rs.close();
        con.desconectar();
        return cliente;
    }

    @Override
    public boolean actualizar(Cliente cliente) throws SQLException {
        boolean rowActualizar = false;
        String query = "UPDATE cliente SET nombre=?, apellido=?, correo=?, celular=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, cliente.getNombre());
        ps.setString(2, cliente.getApellido());
        ps.setString(3, cliente.getCorreo());
        ps.setString(4, cliente.getCelular());
        rowActualizar = ps.executeUpdate() > 0;
        ps.close();
        con.desconectar();
        return rowActualizar;
    }

    @Override
    public boolean eliminar(Cliente cliente) throws SQLException {
        boolean rowEliminar = false;
        String query = "DELETE FROM cliente WHERE id=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, cliente.getId());
        rowEliminar = ps.executeUpdate() > 0;
        ps.close();
        con.desconectar();
        return rowEliminar;
    }
}
