package com.sum8;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class L22EmpJoinDept {
    public static void main(String[] args) {
        String sql= """
            SELECT * 
            FROM EMP e LEFT JOIN DEPT d 
                ON e.DEPTNO=d.DEPTNO 
        """;
        DBManager dbManager=DBManager.getInstance();
        List<L18EmpRecord> empList=new ArrayList<>();
        try (Connection conn=dbManager.getConnection();
             Statement st=conn.createStatement();
             ResultSet rs=st.executeQuery(sql);
        ){
            while (rs.next()){
               L17DeptRecord dept=null;
               Integer deptno=rs.getObject("deptno",Integer.class);
               if(deptno!=null){
                   dept=new L17DeptRecord(
                           deptno,
                           rs.getString("dname"),
                           rs.getString("loc")
                   );
               }
                L18EmpRecord emp=new L18EmpRecord(
                        rs.getInt("empno"),
                        rs.getString("ename"),
                        rs.getString("job"),
                        rs.getObject("mgr",Integer.class),
                        rs.getObject("hiredate", LocalDate.class),
                        rs.getObject("sal",Double.class),
                        rs.getObject("comm",Double.class),
                        deptno,
                        dept
                );
                empList.add(emp);
            }
            System.out.println(empList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
