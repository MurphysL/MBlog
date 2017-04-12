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
 * 注册 RegisterServlet
 * Created by lenovo on 2017/4/9.
 */
@WebServlet(name = "RegisterServlet", value = "/servlet/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        try {
            if(!"".equals(username) && !"".equals(password) && !"".equals(email)){
                int rs = UserDAO.addUser(username , password , email);
                if(rs > 0){
                    User user = UserDAO.query(email, password);
                    if(user != null){
                        request.getSession().setAttribute("user", user);
                        request.getRequestDispatcher("GetBlogServlet").forward(request, response);
                    }else{
                        MError error = new MError();
                        error.setMessage("RegisterServlet");
                        error.setCode(Config.USER_NOT_EXIST);
                        request.setAttribute("error",error);
                        request.getRequestDispatcher("../view/fail.jsp").forward(request, response);
                    }
                }else{
                    MError error = new MError();
                    error.setMessage("RegisterServlet");
                    error.setCode(Config.ADD_USER_FAIL);
                    request.setAttribute("error",error);
                    request.getRequestDispatcher("../view/fail.jsp").forward(request, response);
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
