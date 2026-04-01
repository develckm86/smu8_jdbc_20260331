package com.sum8;

import java.sql.*;

public class L04CreateDept {
    public static void main(String[] args) {
        String url="jdbc:oracle:thin:@//localhost:1521/XEPDB1";
        String user="scott";
        String pw="tiger";
        String sql="INSERT INTO DEPT (deptno,dname,loc) VALUES (?,?,?)";
        try(Connection conn=DriverManager.getConnection(url,user,pw);
            PreparedStatement psmt=conn.prepareStatement(sql);
        ){
            psmt.setInt(1,80);
            psmt.setString(2,"교육");
            psmt.setString(3,"종로구");
            int update=psmt.executeUpdate();
            //dml 은 실행시 정수가 반환 (몇개 성공) Or 오류
            //실패시 0 보다 오류 발생! (if(update>0) 성공은 필요없는 구문)
            System.out.println("등록 성공 :"+update);
        } catch (SQLException e) {
            System.out.println("등록 실패");
            e.printStackTrace();//log4j 로그라이브러리 (로그를 파일로 출력 및 보관)
            //ORA-00001: 무결성 제약 조건(SCOTT.PK_DEPT)에 위배됩니다
            //ORA-01438: 이 열에 대해 지정된 전체 자릿수보다 큰 값이 허용됩니다.
        }
    }
}
