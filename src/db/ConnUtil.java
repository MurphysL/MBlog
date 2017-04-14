package db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DB
 */
public class ConnUtil {
    private static String URL ;
    private static String USER ;
    private static String PASSWORD ;
    private static String DRIVER ;

    private static Connection conn = null;

    static {
        try {
            loadConfig();
            Class.forName(DRIVER);//加载数据库驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载数据库配置
     */
    private static void loadConfig(){
        try {
            InputStream is = ConnUtil.class.getResourceAsStream("../config/jdbc.properties");
            Properties prop = new Properties();
            prop.load(is);
            USER = prop.getProperty("jdbc.username");
            PASSWORD = prop.getProperty("jdbc.password");
            URL = prop.getProperty("jdbc.url");
            DRIVER = prop.getProperty("jdbc.driver");
            System.out.print("COFIG:" +
                    "\nDRIVER:"+DRIVER+
                    "\nURL:"+URL+
                    "\nUSER:"+USER+
                    "\nPASSWORD:"+PASSWORD+"\n");
        } catch (Exception e) {
            throw new RuntimeException("加载配置文件出错！",e);
        }
    }

    public static Connection getInstance() throws SQLException {
        if(conn == null){
            synchronized (ConnUtil.class){
                if(conn == null){
                    conn = DriverManager.getConnection(URL, USER, PASSWORD);
                }
            }
        }
        return conn;
    }

    public static void closeConn() throws SQLException {
        conn.close();
    }

    private ConnUtil() {
    }
}
