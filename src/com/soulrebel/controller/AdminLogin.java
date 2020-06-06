package com.soulrebel.controller;

import com.soulrebel.dao.LoginDaoImpl;
import com.soulrebel.model.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "/login")
public class AdminLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDaoImpl loginDao;

    @Override
    public void init() throws ServletException {
        loginDao = new LoginDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        Login login = new Login();
        login.setUsuario(usuario);
        login.setContrasena(contrasena);

        try {
            if (loginDao.validar(login)){
                response.sendRedirect("login.jsp");
            }else{
                HttpSession session = request.getSession();
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
