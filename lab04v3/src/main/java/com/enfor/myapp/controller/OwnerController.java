package com.enfor.myapp.controller;

import com.enfor.myapp.DAO.OwnerDAO;
import com.enfor.myapp.model.Owner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class OwnerController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/owner.jsp";
    private static String LIST_OWNER = "/listOfOwners.jsp";
    private OwnerDAO ownerDAO;

    public OwnerController() {
        super();
        ownerDAO = new OwnerDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int ownerId = Integer.parseInt(request.getParameter("id"));
            ownerDAO.deleteOwner(ownerId);
            forward = LIST_OWNER;
            request.setAttribute("listOfOwners", ownerDAO.getAllOwners());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            long ownerId = Integer.parseInt(request.getParameter("id"));
            Owner owner = ownerDAO.getOwnerById(ownerId);
            request.setAttribute("owner", owner);
        } else if (action.equalsIgnoreCase("listOwners")){
            forward = LIST_OWNER;
            request.setAttribute("listOfOwners", ownerDAO.getAllOwners());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OwnerDAO ownerDAO = new OwnerDAO();
        Owner owner = new Owner();
        owner.setName(request.getParameter("name"));
        owner.setBirthDate(request.getParameter("birthDate"));
        owner.setAddress(request.getParameter("address"));
        String ownerIq = request.getParameter("iq");
        try {
            owner.setIq(Integer.parseInt(ownerIq));
        } catch (Exception e){
            e.printStackTrace();
        }

        String ownerId = request.getParameter("id");
        if (ownerId == null || ownerId.isEmpty())
        {
            ownerDAO.addOwner(owner);
        }
        else
        {
            owner.setId(Integer.parseInt(ownerId));
            ownerDAO.updateOwner(owner);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_OWNER);
        request.setAttribute("listOfOwners", ownerDAO.getAllOwners());
        view.forward(request, response);

    }
}
