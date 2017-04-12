package bean;

/**
 * 博客类
 * Created by lenovo on 2017/4/10.
 */
public class Blog {
    private int blog_id;
    private String email;
    private String title;
    private String article;
    private int watch;
    private long time;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public int getWatch() {
        return watch;
    }

    public void setWatch(int watch) {
        this.watch = watch;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blog_id=" + blog_id +
                ", email=" + email +
                ", title='" + title + '\'' +
                ", article='" + article + '\'' +
                ", watch=" + watch +
                ", time=" + time +
                '}';
    }
}
