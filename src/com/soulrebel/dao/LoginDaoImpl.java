package com.soulrebel.dao;

import com.soulrebel.model.Login;

import java.sql.*;


public class LoginDaoImpl implements LoginDao {
    @Override
    public boolean validar(Login login) throws ClassNotFoundException {

        boolean estatus = false;
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/javaSena?useSSL=false", "root", "soulman");
             PreparedStatement preparedStatement = connection
                     .prepareStatement
                             ("select * from login where usuario = ? and contrasena=?")) {
            preparedStatement.setString(1, login.getUsuario());
            preparedStatement.setString(2, login.getContrasena());

            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            estatus = resultSet.next();
        } catch (SQLException throwables) {
            printSQLException(throwables);
        }

        return estatus;
    }

    @Override
    public void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error de código: " + ((SQLException) e).getErrorCode());
                System.err.println("Mensaje: " + e.getMessage());
                Throwable throwable = ex.getCause();
                while (throwable != null) {
                    System.out.println("Causa: " + throwable);
                    throwable = throwable.getCause();
                }
            }
        }
    }
}
