package servlet;

import bean.User;
import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 *  登录
 *  session : user---User
 *
 * Created by lenovo on 2017/4/9.
 */
@WebServlet(name = "LoginServlet", value = "/servlet/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        try {
            if(!"".equals(password) && !"".equals(email)){
                User user = UserDAO.query(email, password);

                if(user == null){
                    response.sendRedirect("../view/fail.jsp");
                }else{
                    request.getSession().setAttribute("user", user);
                    response.sendRedirect("MainServlet?page=1");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
