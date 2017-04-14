package servlet;

import bean.Blogs;
import config.Config;
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
        int page = Integer.parseInt(request.getParameter("page"));
        try {
            Blogs blogs = BlogDAO.queryPagingBlog(page);
            int num = BlogDAO.queryBlogNum();
            int pages;
            StringBuffer sb = new StringBuffer();
            if(num % Config.PAGE_BLOG_NUM == 0){
                pages = num / Config.PAGE_BLOG_NUM;
            }else{
                pages = num / Config.PAGE_BLOG_NUM + 1;
            }
            String unselect_css = "margin: 10px;\n" +
                    "\tbackground-color: #040E17;\n" +
                    "\ttext-decoration: none;\n" +
                    "\tfont-size: 20px;\n" +
                    "\tfont-weight: 900;\n" +
                    "\tcolor: white;\n" +
                    "\twidth: 30px;\n" +
                    "\tline-height: 30px;\n" +
                    "\tdisplay: inline-block;\n" +
                    "\tborder-radius: 25px;";
            String select_css = "margin: 10px;\n" +
                    "\tbackground-color: #FFA500;\n" +
                    "\ttext-decoration: none;\n" +
                    "\tfont-size: 20px;\n" +
                    "\tfont-weight: 900;\n" +
                    "\tletter-spacing: 1px;\n" +
                    "\tcolor: white;\n" +
                    "\twidth: 30px;\n" +
                    "\tline-height: 30px;\n" +
                    "\tdisplay: inline-block;\n" +
                    "\tborder-radius: 25px;";
            for(int i = 1 ;i <= pages ;i ++){
                if(i == page){
                    sb.append("<a href=../../servlet/MainServlet?page=")
                            .append(i)
                            .append(" id=\"select\" style=\"")
                            .append(select_css)
                            .append("\">")
                            .append(i)
                            .append("</a>");
                }else{
                    sb.append("<a href=../../servlet/MainServlet?page=")
                            .append(i)
                            .append(" id=\"select\" style=\"")
                            .append(unselect_css)
                            .append("\">")
                            .append(i)
                            .append("</a>");
                }
            }
            request.getSession().setAttribute("bar", sb.toString());
            request.getSession().setAttribute("blogs", blogs);
            response.sendRedirect("/jsp/view/main.jsp");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
