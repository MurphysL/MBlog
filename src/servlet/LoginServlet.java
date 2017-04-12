package servlet;

import bean.MError;
import bean.User;
import config.Config;
import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 用户登录Servlet
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
                    MError error = new MError();
                    error.setCode(Config.USER_NOT_EXIST);
                    error.setMessage("RegisterServlet");
                    request.setAttribute("error",error);
                    request.getRequestDispatcher("../jsp/view/fail.jsp").forward(request, response);
                }else{
                    request.getSession().setAttribute("user", user);
                    request.getRequestDispatcher("MainServlet").forward(request, response);
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
