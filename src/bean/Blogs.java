package bean;

import java.util.List;

/**
 * 博客集合类
 * Created by lenovo on 2017/4/12.
 */
public class Blogs {

    private int num;
    private List<Blog> blogs;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
