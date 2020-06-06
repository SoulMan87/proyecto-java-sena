package com.soulrebel.dao;

import com.soulrebel.model.Login;

import java.sql.SQLException;

public interface LoginDao {

    boolean validar(Login login)throws ClassNotFoundException;

    void printSQLException(SQLException ex);
}
