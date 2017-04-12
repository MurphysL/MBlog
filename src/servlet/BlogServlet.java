package servlet;

import bean.Blog;
import dao.BlogDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 博客文章类
 * Created by lenovo on 2017/4/12.
 */
@WebServlet(name = "BlogServlet",value = "/servlet/BlogServlet")
public class BlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int blog_id = Integer.parseInt( request.getParameter("blog_id"));
            Blog blog = BlogDAO.queryByBlogId(blog_id);
            request.setAttribute("blog", blog);
            request.getRequestDispatcher("../jsp/view/article.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
