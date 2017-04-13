package servlet;

import dao.BlogDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 删除
 * Created by lenovo on 2017/4/13.
 */
@WebServlet(name = "DeleteServlet", value = "/servlet/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int blog_id = Integer.parseInt(request.getParameter("blog_id"));

        try {
            if(BlogDAO.deleteByBlogId(blog_id) > 0){
                response.sendRedirect("../jsp/view/success.jsp");
            }else{
                response.sendRedirect("../jsp/view/fail.jsp");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
