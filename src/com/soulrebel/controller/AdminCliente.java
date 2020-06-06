package com.soulrebel.controller;

import com.soulrebel.dao.ClienteDaoImpl;
import com.soulrebel.model.Cliente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/adminCliente")
public class AdminCliente extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ClienteDaoImpl clienteDaoImpl;

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbc:mysql://localhost:3306/senaJava");
        String jdbcUsername = getServletContext().getInitParameter("root");
        String jdbcPassword = getServletContext().getInitParameter("soulman");
        try {
            clienteDaoImpl = new ClienteDaoImpl(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public AdminCliente() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Hola servlet");
        String action = request.getParameter("action");
        System.out.println(action);
        try {
            switch (action) {
                case "index":
                    index(request, response);
                    break;
                case "nuevo":
                    nuevo(request, response);
                    break;
                case "register":
                    register(request, response);
                    break;
                case "mostrar":
                    mostrar(request, response);
                    break;
                case "showedit":
                    showEditar(request, response);
                    break;
                case "editar":
                    editar(request, response);
                    break;
                case "eliminar":
                    eliminar(request, response);
                default:
                    break;
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void index(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void register(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        Cliente cliente = new Cliente(0, request.getParameter("nombre"), request.getParameter("apellido"),
                request.getParameter("correo"), request.getParameter("celular"));
        clienteDaoImpl.insertar(cliente);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void nuevo(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/register.jsp");
        dispatcher.forward(request, response);
    }

    private void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrar.jsp");
        List<Cliente> listaClientes = clienteDaoImpl.listarClientes();
        request.setAttribute("lista", listaClientes);
        dispatcher.forward(request, response);
    }

    private void showEditar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        Cliente cliente = clienteDaoImpl.optenerClientePorId(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("cliente", cliente);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editar.jsp");
        dispatcher.forward(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        Cliente cliente = new Cliente(Integer.parseInt(request.getParameter("id")), request.getParameter("nombre"),
                request.getParameter("apellido"), request.getParameter("correo"), request.getParameter("celular"));
        clienteDaoImpl.actualizar(cliente);
        index(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Cliente cliente = clienteDaoImpl.optenerClientePorId(Integer.parseInt(request.getParameter("id")));
        clienteDaoImpl.eliminar(cliente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }
}
