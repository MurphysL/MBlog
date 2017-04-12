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
        }
        return user;
    }

    public static List<User> queryAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM user;";
        PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
        ResultSet set = ps.executeQuery();
        List<User> list = new ArrayList<>();
        while(set.next()){
            User user = new User();
            user.setUsername(set.getString(2));
            user.setPassword(set.getString(3));
            list.add(user);
        }
        return list;
    }


    public static int addUser(String username , String password, String email) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO user(username, password, email) VALUES(?,?,?);";
        PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ps.setString(3, email);
        return ps.executeUpdate();
    }

    public static int update(User user) throws SQLException, ClassNotFoundException {
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
    }
}
