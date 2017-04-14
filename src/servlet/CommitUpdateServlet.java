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
 * Blog 更新提交
 * Created by lenovo on 2017/4/14.
 */
@WebServlet(name = "CommitUpdateServlet" , value="/servlet/CommitUpdateServlet")
public class CommitUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int blog_id = Integer.parseInt(request.getParameter("blog_id"));
        String title = request.getParameter("title");
        String article =request.getParameter("article");

        try {
            if(BlogDAO.updateBlogContent(blog_id, title, article)!=0){
                response.sendRedirect("../jsp/view/success.jsp");
            }else{
                response.sendRedirect("../jsp/view/fail.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
