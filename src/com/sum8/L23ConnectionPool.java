package com.sum8;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class L23ConnectionPool {
    //Connection POOL 은 커넥션객체를 바로 반환하지 않고 DataSource를 반환
    private final HikariDataSource dataSource;
    private static L23ConnectionPool INSTANCE=new L23ConnectionPool();

    private L23ConnectionPool(){
        HikariConfig config=new HikariConfig(); //컨넥션 풀 설정
        config.setJdbcUrl(Scott.URL);
        config.setUsername(Scott.USERNAME);
        config.setPassword(Scott.PASSWORD);
        config.setMaximumPoolSize(5);
        config.setMinimumIdle(2);
        config.setConnectionTimeout(10000);
        dataSource=new HikariDataSource(config);
    }
    public static L23ConnectionPool getInstance(){
        return INSTANCE;
    }
// 일반적으로 datasource 를 받아서 connection 호출
//    public HikariDataSource getDataSource() throws SQLException {
//        return dataSource;
//    }
    public Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }
}
class ConnPoolTest{
    public static void main(String[] args) {
        L23ConnectionPool connectionPool=L23ConnectionPool.getInstance();
        try(Connection conn=connectionPool.getConnection()){
            System.out.println(conn); //31c88ec8
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try(Connection conn=connectionPool.getConnection()){
            System.out.println(conn); //31c88ec8
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


