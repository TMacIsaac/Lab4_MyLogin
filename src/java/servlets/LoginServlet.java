
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.AccountService;
import services.User;


/**
 *
 * @author 838771
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(request.getParameter("logout") != null){
            session.invalidate();
            request.setAttribute("loginMessage", "User Logged Out Successfully!");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        else if(session.getAttribute("username")!=null){
            response.sendRedirect(request.getContextPath() + "/home");
        }
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user,pass;
        User userObj = null;
        user = request.getParameter("username");
        pass = request.getParameter("password");
        if(user == null || pass == null || user.isEmpty() || user.equals("") || pass.isEmpty() || pass.equals("") || user == null || pass == null){
            request.setAttribute("currentUser", user);
            request.setAttribute("currentPass", pass);
            request.setAttribute("loginMessage", "A field was left empty.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        else{
            AccountService a = new AccountService();
            
            userObj = a.login(user, pass);
        }
        
        if(userObj == null){
            request.setAttribute("currentUser", user);
            request.setAttribute("currentPass", pass);
            request.setAttribute("loginMessage", "Invalid Credentials.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        else{
            HttpSession session = request.getSession();
            session.setAttribute("username", user);
            response.sendRedirect(request.getContextPath() + "/home");
            
        }
    }

   

}
