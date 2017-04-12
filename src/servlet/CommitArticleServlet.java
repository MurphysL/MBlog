package servlet;

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
 * 上传博客类
 *
 * Created by lenovo on 2017/4/11.
 */
@WebServlet(name = "CommitArticleServlet" , value = "/servlet/CommitArticleServlet")
public class CommitArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title");
        String article =request.getParameter("article");
        User user = (User) request.getSession().getAttribute("user");
        String email = user.getEmail();
        try {
            int rs = BlogDAO.addBlog(email, title, article);
            if(rs > 0){
                request.getRequestDispatcher("../jsp/view/blog.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("../jsp/fail.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
