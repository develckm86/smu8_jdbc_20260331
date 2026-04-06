package com.sum8;

import java.sql.Connection;
import java.sql.SQLException;

public class DBManager {
    private DBManager(){};//외부에서 객체 생성을 막는다.
    private static DBManager INSTANCE=new DBManager();
    public static DBManager getInstance(){
        return INSTANCE;
    }
    private Connection conn;
    public Connection getConnection() throws SQLException {
        conn=java.sql.DriverManager.getConnection(Scott.URL,Scott.USERNAME,Scott.PASSWORD);
        return conn;
    }

}
class A{}

//테스트만 하는 어플(지워도 상관없음)
class DBManagerTestApp{
    public static void main(String[] args) {
        //DBManager dbManager=new DBManager();
        A a=new A();
        A a2=new A();
        System.out.println(a);//com.sum8.A@4e50df2e
        System.out.println(a2);//com.sum8.A@1d81eb93
        System.out.println(a==a2);//false

        DBManager db1=DBManager.getInstance();
        DBManager db2=DBManager.getInstance();
        System.out.println(db1); //com.sum8.DBManager@34a245ab
        System.out.println(db2); //com.sum8.DBManager@34a245ab
        System.out.println(db1==db2);//true
    }
}