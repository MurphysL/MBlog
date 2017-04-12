package servlet;

import bean.Blogs;
import bean.User;
import dao.BlogDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 博客查询类
 * Created by lenovo on 2017/4/11.
 */
@WebServlet(name = "MainServlet", value = "/servlet/MainServlet")
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        User user = (User) request.getSession().getAttribute("user");
        if(user != null){
            int id = user.getId();
            try {
                Blogs blogs = BlogDAO.querySortBlog(1, 4);
                System.out.println("------querySortBlog-----");
                request.setAttribute("blogs", blogs);
                request.getRequestDispatcher("../jsp/view/main.jsp").forward(request, response);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
