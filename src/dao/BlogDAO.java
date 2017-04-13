package dao;

import bean.Blog;
import bean.Blogs;
import config.Config;
import db.ConnUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Blog DAO
 * Created by lenovo on 2017/4/10.
 */
public class BlogDAO {
    /**
     * 添加 Blog
     *
     * @param email 用户邮箱
     * @param article 正文
     * @param title 标题
     * @return 更改条数
     * @throws SQLException SQLException
     * @throws ClassNotFoundException ClassNotFoundException
     */
    public static int insertBlog(String email , String title, String article) throws SQLException, ClassNotFoundException {
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
     *  查询 Blog 总数
     *
     * @return Blog 总数
     * @throws SQLException SQLException
     * @throws ClassNotFoundException ClassNotFoundException
     */
    public static int queryBlogNum() throws SQLException, ClassNotFoundException {
        String sql = "SELECT COUNT(blog_id) FROM blog;";
        PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int num = 0;
        while(rs.next()){
            num = rs.getInt(1);
        }
        return num;
    }

    /**
     * 分页查询 Blog
     *
     * @param page 页数
     * @return Blog 列表
     * @throws SQLException SQLException
     * @throws ClassNotFoundException ClassNotFoundException
     */
    public static Blogs queryPagingBlog(int page) throws SQLException, ClassNotFoundException {
        int start = (page-1)* Config.PAGE_BLOG_NUM;
        int end = start+4;
        String sql = "SELECT * FROM blog ORDER BY watch DESC LIMIT ? , ?;";
        PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
        ps.setInt(1, start);
        ps.setInt(2, end);
        ResultSet rs = ps.executeQuery();

        List<Blog> list = new ArrayList<>();
        Blogs blogs = new Blogs();
        blogs.setNum(0);
        while(rs.next()){
            blogs.setNum(1);
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

    /**
     * 通过 Blog 主键查询 Blog
     * @param blog_id  Blog 主键
     * @return Blog
     * @throws SQLException SQLException
     * @throws ClassNotFoundException ClassNotFoundException
     */
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

    public static Blog queryByEmailAndTitle(String email, String title) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM blog WHERE email = ? AND title = ?";
        PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
        ps.setString(1, email);
        ps.setString(2,title);
        ResultSet rs = ps.executeQuery();

        Blog blog = new Blog();
        while(rs.next()){
            blog.setTitle(rs.getString(2));
            blog.setBlog_id(rs.getInt(1));
            blog.setArticle(rs.getString(3));
            blog.setWatch(rs.getInt(4));
            blog.setTime(rs.getLong(5));
            blog.setEmail(rs.getString(6));
        }
        return blog;
    }

    /**
     * 通过 Blog 主键删除
     * @param blog_id Blog主键
     * @return 影响条数
     * @throws SQLException SQLException
     * @throws ClassNotFoundException ClassNotFoundException
     */
    public static int deleteByBlogId(int blog_id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM blog WHERE blog_id = ?;";
        PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
        ps.setInt(1, blog_id);

        return ps.executeUpdate();
    }


}
