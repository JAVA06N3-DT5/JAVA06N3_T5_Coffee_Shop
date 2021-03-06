package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    private Connection connection;

    private ConnectDB() {
        try {
        	
            connection = DriverManager.getConnection(Config.URL.getValue(), Config.USER.getValue(), Config.PASS.getValue());

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static class ConnectionHelper {
        
        public static final ConnectDB instance = new ConnectDB();
    }

    public static ConnectDB getInstance() {

        return ConnectionHelper.instance;
    }

    // Nhớ đổi username password và port trước khi chạy 
    public Connection getConnection() {

        return connection;
    }

}
