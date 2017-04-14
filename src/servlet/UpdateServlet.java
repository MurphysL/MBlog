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
 * 文章编辑
 * Created by lenovo on 2017/4/14.
 */
@WebServlet(name = "UpdateServlet",value = "/servlet/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int blog_id = Integer.parseInt(request.getParameter("blog_id"));
        try {
            Blog blog = BlogDAO.queryByBlogId(blog_id);
            request.getSession().setAttribute("editor_blog", blog);
            response.sendRedirect("../jsp/view/update_editor.jsp");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
