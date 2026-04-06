package com.sum8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class L21DBManager {
    //싱글톤으로 구현하는 db 커넥션을 반환하는 DBManager
    //1.객체를 외부에서 생성하지 못하게 막기 private 생성자
    //2.내부에서 객체를 만들어서 반환 (캡슐화)
    //3.참조할 함수를 static 이 아니게 생성
    
    private L21DBManager(){}
    private static L21DBManager INSTANCE=new L21DBManager();
    public static L21DBManager getInstance(){
        return INSTANCE;
    }//내부에서 생성한 객체를 재사용하는 구조 (외부에서는 절대 객체를 생성할 수 없음)


    private Connection conn;
    public Connection getConnection() throws SQLException {
        String url="jdbc:oracle:thin:@//localhost:1521/XEPDB1";
        String user="scott";
        String pw="tiger";
        return DriverManager.getConnection(url,user,pw);
    }
}
class Test{
    public static void main(String[] args) {
        //Connection conn=L21DBManager.getConnection();
        //객체 생성 없이 Connection을 반환받으려고 static을 작성했는데 아직 객체 생성이 가능한 상태
        //->객체를 한번만 생성할 수 있게만드는 것 -> 싱글톤 디자인 패턴
        //디자인패턴 : 어떤 도구 없이 구조적인 것으로 기능을 구현 (객체를 한번만 만드는 기능)
        //Connection conn2=new L21DBManager().getConnection();
        //싱글톤으로 생성한 객체 호출
        L21DBManager dbManager=L21DBManager.getInstance();
        try {
            Connection conn=dbManager.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}