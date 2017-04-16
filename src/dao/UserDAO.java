package dao;

import bean.User;
import db.ConnUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * UserDAO
 *
 * Created by MurphySL on 2017/3/21.
 */
public class UserDAO {

    /**
     * 根据 E-mail 查询
     * @param email 电子邮箱
     * @param password 密码
     * @return 用户信息
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static User query(String email, String password) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet set = ps.executeQuery();
        User user = new User();
        while(set.next()){
            user.setUsername(set.getString(2));
            user.setPassword(set.getString(3));
            user.setEmail(set.getString(4));
            user.setAvatar(set.getString(5));
        }
        return user;
    }

    /**
     * 添加用户
     * @param username 用户名
     * @param password 密码
     * @param email 电子邮箱
     * @param avatar 头像
     * @return 影响行数
     * @throws SQLException SQLException
     * @throws ClassNotFoundException ClassNotFoundException
     */
    public static int insertUser(String username , String password, String email, String avatar) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO user(username, password, email, avatar) VALUES(?,?,?,?);";
        PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ps.setString(3, email);
        ps.setString(4, avatar);
        return ps.executeUpdate();
    }

   /* public static int update(User user) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE user SET username='"+user.getUsername()+"',password='"+user.getPassword()
                +"' WHERE username= '"+user.getUsername()+"';";
        System.out.print(sql);
        PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
        return ps.executeUpdate();
    }

    public static int deleteByUsername(String username) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM user WHERE username = \""+username+"\";";
        PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
        return ps.executeUpdate();
    }*/
}
