package ua.lviv.lgs;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Registretion")
public class Registretion extends HttpServlet {
    private static final long serialVersionUID = 1L;
	private UserService userService = UserService.getUserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        userService.addUser(new User(firstName,lastName,email,password));
        HttpSession session = request.getSession(true);
        session.setAttribute("userEmail",email);
        session.setAttribute("userName",firstName);
        request.getRequestDispatcher("cabinet.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
