package Servlets;

import Entity.Owner;
import Model.DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DAO dao;

    public void init() {
        String URL = getServletContext().getInitParameter("URL");
        String Username = getServletContext().getInitParameter("Username");
        String Password = getServletContext().getInitParameter("Password");
        dao = new DAO(URL, Username, Password);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    createOwner(request, response);
                    break;
                case "/delete":
                    deleteOwner(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateOwner(request, response);
                    break;
                case "/list":
                    listOwners(request, response);
                    break;
                default:
                    listOwners(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listOwners(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Owner> listOwners = dao.listAllOwners();
        request.setAttribute("listOwners", listOwners);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Owner existingOwner = dao.getOwner(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        request.setAttribute("owner", existingOwner);
        dispatcher.forward(request, response);
    }

    private void createOwner(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        try {
            String name = request.getParameter("name");
            Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthDate"));
            String address = request.getParameter("address");
            int iq = Integer.parseInt(request.getParameter("iq"));
            Owner owner = new Owner(name, birthDate, address, iq);
            dao.create(owner);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        response.sendRedirect("list");
    }

    private void updateOwner(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthDate"));
            String address = request.getParameter("address");
            int iq = Integer.parseInt(request.getParameter("iq"));
            Owner owner = new Owner(id, name, birthDate, address, iq);
            dao.updateOwner(owner);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        response.sendRedirect("list");
    }

    private void deleteOwner(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Owner owner = new Owner(id);
        dao.deleteOwner(owner);
        response.sendRedirect("list");
    }
}
