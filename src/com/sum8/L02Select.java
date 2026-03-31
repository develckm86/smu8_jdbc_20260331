package com.sum8;

import java.sql.*;

public class L02Select {
    public static void main(String[] args) throws Exception {
        String url="jdbc:oracle:thin:@//localhost:1521/XEPDB1";
        String user="scott"; //db는 계정의 대소문자 구분이 없는데 jdbc를 사용할때 대소문자 구분을 함
        String pw="tiger";
        String sql="SELECT * FROM DEPT";
        Connection conn=null; //데이터소스
        Statement stmt=null; //sql 실행객체
        ResultSet rs=null; //table 의 데이터(select를 실행한 결과)
        conn=DriverManager.getConnection(url,user,pw);
        System.out.println(conn);
        //Statement 접속객체가 반환(준다)하는 쿼리 실행객체
        stmt=conn.createStatement();
        rs=stmt.executeQuery(sql); //select,  executeUpdate(dml)
        //select 의 실행결과는 테이블로 테이블의 데이터 타입은 ResultSet(이터레이터로 사용) 이다.
        while (rs.next()){//부서가 4개 있으니 4번 이동
            String id=rs.getString("deptno");
            String name=rs.getString("dname");
            String loc=rs.getString("loc");
            System.out.println(id+" | "+name+" | "+loc);
        }
    }
}
