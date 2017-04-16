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
import java.util.Random;

/**
 *  注册
 *  session:user--User
 *
 * Created by lenovo on 2017/4/9.
 */
@WebServlet(name = "RegisterServlet", value = "/servlet/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        Random random = new Random();
        String avatar = String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(1000));

        try {
            if(!"".equals(username) && !"".equals(password) && !"".equals(email)){
                int rs = UserDAO.insertUser(username , password , email, avatar);
                if(rs > 0){
                    User user = UserDAO.query(email, password);
                    if(user != null){
                        request.getSession().setAttribute("user", user);
                        response.sendRedirect("MainServlet?page=1");
                    }else{
                        response.sendRedirect("../view/fail.jsp");
                    }
                }else{
                    response.sendRedirect("../view/fail.jsp");
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
