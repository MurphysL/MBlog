package dao;

import bean.Blog;
import bean.Blogs;
import db.ConnUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 博客类
 * Created by lenovo on 2017/4/10.
 */
public class BlogDAO {
    /**
     * 添加博客
     * @param email 用户邮箱
     * @param article 文章
     * @param title 标题
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static int addBlog(String email , String title, String article) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO blog(email, title, article, watch , time) VALUES(?,?,?,?,?);";
        Long date = System.currentTimeMillis();
        PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
        ps.setString(1, email);
        ps.setString(2, title);
        ps.setString(3, article);
        ps.setInt(4, 0);
        ps.setLong(5, date);

        return ps.executeUpdate();
    }

    /**
     * 文章大概信息
     *
     * @param start
     * @param end
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Blogs querySortBlog(int start , int end) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM blog ORDER BY watch DESC LIMIT ? , ?;";
        PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
        ps.setInt(1, start);
        ps.setInt(2, end);
        ResultSet rs = ps.executeQuery();

        List<Blog> list = new ArrayList<>();
        Blogs blogs = new Blogs();
        blogs.setStatus(0);
        while(rs.next()){
            blogs.setStatus(1);
            Blog blog = new Blog();
            blog.setBlog_id(rs.getInt(1));
            blog.setTitle(rs.getString(2));
            blog.setArticle(rs.getString(3));
            blog.setWatch(rs.getInt(4));
            blog.setTime(rs.getLong(5));
            blog.setEmail(rs.getString(6));
            list.add(blog);
        }
        blogs.setBlogs(list);

        return blogs;
    }

    public static Blog queryByBlogId(int blog_id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM blog WHERE blog_id = ?";
        PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
        ps.setInt(1, blog_id);
        ResultSet rs = ps.executeQuery();

        Blog blog = new Blog();
        while(rs.next()){
            blog.setBlog_id(rs.getInt(1));
            blog.setTitle(rs.getString(2));
            blog.setArticle(rs.getString(3));
            blog.setWatch(rs.getInt(4));
            blog.setTime(rs.getLong(5));
            blog.setEmail(rs.getString(6));
        }
        return blog;
    }

    public static Blogs queryBlog(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM blog WHERE id = ?";
        PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        List<Blog> list = new ArrayList<>();
        Blogs blogs = new Blogs();
        blogs.setStatus(0);
        while(rs.next()){
            Blog blog = new Blog();
            blog.setBlog_id(rs.getInt(1));
            blog.setTitle(rs.getString(2));
            blog.setArticle(rs.getString(3));
            blog.setWatch(rs.getInt(4));
            blog.setTime(rs.getLong(5));
            blog.setEmail(rs.getString(6));
            list.add(blog);
            blogs.setStatus(1);
        }
        blogs.setBlogs(list);
        return blogs;
    }


}
