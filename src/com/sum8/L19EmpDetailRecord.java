package com.sum8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class L19EmpDetailRecord {
    public static void main(String[] args) {
        String sql="SELECT * FROM EMP WHERE empno=?";
        int empno=7902;
        L18EmpRecord emp=null;
        try (Connection conn= DriverManager.getConnection(Scott.URL,Scott.USERNAME,Scott.PASSWORD);
             PreparedStatement ps=conn.prepareStatement(sql);){
            ps.setInt(1,empno);
            try(ResultSet rs=ps.executeQuery()){
                if(rs.next()){
                    emp=new L18EmpRecord(
                            rs.getInt("empno"),
                            rs.getString("ename"),
                            rs.getString("job"),
                            rs.getObject("mgr",Integer.class),
                            rs.getObject("hiredate", LocalDate.class),
                            rs.getObject("sal", Double.class),
                            rs.getObject("comm", Double.class),
                            rs.getObject("deptno", Integer.class),
                            null
                    );
                }
                System.out.println(emp.toString());
                System.out.println(emp.ename());
                System.out.println(emp.job());
                System.out.println(emp.hiredate());
                System.out.println(emp.comm());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
