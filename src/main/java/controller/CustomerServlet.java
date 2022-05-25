package controller;

import model.Customer;
import service.CustomerDAO;
import service.ICustomerDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

//import static java.awt.AWTEventMulticaster.save;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    CustomerDAO customerDAO = new CustomerDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("act");
        if (action == null) ;
        {
            action = "";

        }
        switch (action) {
            case"create":
                showCreatForm(request,response);

            default:
                showList(request, response);
        }
    }

    private void showCreatForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/creat.jsp");
        List<Customer> customers= customerDAO.findAll();
        requestDispatcher. forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/list.jsp");
        List<Customer> customers= customerDAO.findAll();
        request.setAttribute("dskh",customers);
        requestDispatcher. forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDAO customerDAO = new CustomerDAO();
            String action = request.getParameter("act");
            if (action == null) ;
            {
                action = "";

            }
            switch (action) {
                case"create":
                    save(request,response);
            }
        }

        


    private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name =request.getParameter("name");
       int age =Integer.parseInt(request.getParameter("age"));
//       customerDAO.insert(new Customer(name,age));
//        response.sendRedirect("/customers");
    }
}
