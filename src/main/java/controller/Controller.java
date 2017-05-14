package controller;

import dao.ContactDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contact;

public class Controller extends HttpServlet {
    private ContactDAO dao;
    private String insert;
    private String list;
    
    public Controller(){
        dao = new ContactDAO();
        insert = "addContact.jsp";
        list = "allContacts.jsp";
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String goToPage = "";
        
        if (action.equals(("displayContacts"))){
            request.setAttribute("contacts", dao.getContacts());
            goToPage = list;
        }
        else if (action.equals("insert")){
            goToPage = insert;
        }
        
        RequestDispatcher view = request.getRequestDispatcher(goToPage);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Contact newContact = new Contact();
        newContact.setName(request.getParameter("newName"));
        newContact.setLastName(request.getParameter("newLastName"));
        newContact.setMail(request.getParameter("newMail"));
        newContact.setNumber(request.getParameter("newNumber"));
        newContact.setBornDate(request.getParameter("newBornDate"));
        dao.addContact(newContact);
        
        request.setAttribute("contacts", dao.getContacts());
        RequestDispatcher view = request.getRequestDispatcher(list);
        view.forward(request, response);
    }
}