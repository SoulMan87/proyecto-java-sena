package com.soulrebel.dao;

import com.soulrebel.model.Conexion;
import com.soulrebel.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDaoImpl implements ProductoDao {
    private Conexion con;
    private Connection connection;

    public ProductoDaoImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }

    @Override
    public boolean insertarProducto(Producto producto) throws SQLException {
        String sql = "INSERT INTO producto (id, nombre, cantidad, precio) VALUES (?,?,?,?)";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, null);
        statement.setString(2, producto.getNombre());
        statement.setInt(3, producto.getCantidad());
        statement.setFloat(4, producto.getPrecio());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }

    @Override
    public List<Producto> listarProductos() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT * FROM producto";
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nombre = resultSet.getString("nombre");
            int cantidad = resultSet.getInt("cantidad");
            float precio = resultSet.getFloat("precio");
            Producto producto = new Producto(id, nombre, cantidad, precio);
            productos.add(producto);
        }
        con.desconectar();
        return productos;
    }

    @Override
    public boolean eliminarProducto(Producto producto) throws SQLException {
        boolean rowActualizar = false;
        String query = "UPDATE producto SET nombre=?, cantidad=?, precio=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, producto.getNombre());
        ps.setInt(2, producto.getCantidad());
        ps.setFloat(3, producto.getPrecio());
        rowActualizar = ps.executeUpdate() > 0;
        ps.close();
        con.desconectar();
        return rowActualizar;
    }

    @Override
    public boolean actualizarProducto(Producto producto) throws SQLException {
        boolean rowEliminar = false;
        String query = "DELETE FROM producto WHERE id=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, producto.getId());
        rowEliminar = ps.executeUpdate() > 0;
        ps.close();
        con.desconectar();
        return rowEliminar;
    }

    @Override
    public Producto optenerProductoPorId(int id) throws SQLException {
        Producto producto = null;
        String query = "SELECT * FROM producto WHERE id=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            producto = new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getInt("cantidad"),
                    rs.getFloat("precio"));
        }
        rs.close();
        con.desconectar();
        return producto;
    }
}
