package com.sum8;

import java.sql.*;
import java.time.LocalDate;

public class L08EmpRead {
    public static void main(String[] args) {
        String sql="SELECT * FROM EMP";
        try (Connection conn= DriverManager.getConnection(Scott.URL,Scott.USERNAME,Scott.PASSWORD);
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
        ){
            StringBuilder sb=new StringBuilder();
            while (rs.next()){
                //잘못된 방식 (타입) 기본형은 null 불가기 때문에 Null 데이터를 0으로 받는다.
                int empno=rs.getInt("empno");
                Integer mgr=rs.getObject("mgr",Integer.class);
                Integer deptno=rs.getObject("deptno",Integer.class);
                Double sal=rs.getObject("sal",Double.class);
                Double comm=rs.getObject("comm",Double.class);
                String ename=rs.getString("ename");
                String job=rs.getString("job");
                LocalDate hiredate=rs.getObject("hiredate",LocalDate.class);
                String row=empno+"|"+ename+"|"+job+"|"+hiredate+"|"+sal+"|"+comm+"|"+mgr+"|"+deptno+"|"+"\n";
                sb.append(row);
            }
            System.out.println(sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
