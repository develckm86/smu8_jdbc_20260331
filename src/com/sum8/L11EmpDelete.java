package com.sum8;

import java.sql.*;

public class L11EmpDelete {
    public static void main(String[] args) {
        //급여기록 테이블이 사원을 참조하기 때문에 급여기록을 지우고 사원을 지워야합니다!
        String sqlPay="DELETE FROM PAY_HISTORY WHERE EMPNO=?";
        String sqlEmp="DELETE FROM EMP WHERE EMPNO=?";
        int empno=7934;
        try (Connection conn= DriverManager.getConnection(Scott.URL,Scott.USERNAME,Scott.PASSWORD);
             PreparedStatement psPay=conn.prepareStatement(sqlPay);
             PreparedStatement psEmp=conn.prepareStatement(sqlEmp);
        ){
            conn.setAutoCommit(false);
            conn.commit();
            psPay.setInt(1,empno);
            int update=psPay.executeUpdate();
            System.out.println("급여기록 삭제 :"+update);

            psEmp.setInt(1,empno);
            update=psEmp.executeUpdate();
            if(update==0){
                System.out.println("존재하지 않는 사원입니다.");
            }else {
                System.out.println("삭제 성공!");
            }
            conn.rollback(); //삭제한 사원 취소!
        } catch (SQLException e) {
            //삭제시 오류가 거의 발생하지 않음 (fk 제외)
            throw new RuntimeException(e);
        }
    }
}
