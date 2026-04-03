package com.sum8.last;
import java.sql.*;

public final class DBManager {
    private static final DBManager INSTANCE = new DBManager();

    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
    private static final String USER = "scott";
    private static final String PASSWORD = "tiger";

    private boolean debug;
    private int requestCount;
    private String lastErrorMessage;

    private DBManager() {
    }

    public static DBManager getInstance() {
        return INSTANCE;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public boolean isDebug() {
        return debug;
    }

    public int getRequestCount() {
        return requestCount;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }

    public Connection getConnection() throws SQLException {
        requestCount++;

        if (debug) {
            System.out.println("[DBManager] connection request count = " + requestCount);
        }

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            lastErrorMessage = e.getMessage();
            throw e;
        }
    }

}
