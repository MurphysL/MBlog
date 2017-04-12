package bean;

import java.util.List;

/**
 * 博客集合类
 * Created by lenovo on 2017/4/12.
 */
public class Blogs {
    /**
     * status : 1---正常 0--错误
     */
    private int status;
    private List<Blog> blogs;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
