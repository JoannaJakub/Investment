package pl.coderslab.springboot.controller;

import pl.coderslab.springboot.EmailUtility;
import pl.coderslab.springboot.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@WebServlet("/reset_password")
public class ResetPasswordServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private String host;
    private String port;
    private String email;
    private String name;
    private String pass;

    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        email = context.getInitParameter("email");
        name = context.getInitParameter("name");
        pass = context.getInitParameter("pass");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String page = "reset_password.jsp";
        request.getRequestDispatcher(page).forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String recipient = request.getParameter("email");
        String subject = "Your Password has been reset";

        EmailUtility emailUtility = new EmailUtility(request, response);
        String newPassword = emailUtility.resetCustomerPassword(recipient);

        String content = "Hi, this is your new password: " + newPassword;
        content += "\nNote: for security reason, "
                + "you must change your password after logging in.";

        String message = "";

        try {
            EmailUtility.sendEmail(host, port, email, name, pass,
                    recipient, subject, content);
            message = "Your password has been reset. Please check your e-mail.";
        } catch (Exception ex) {
            ex.printStackTrace();
            message = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("message", message);
            request.getRequestDispatcher("message.jsp").forward(request, response);
        }
    }

}