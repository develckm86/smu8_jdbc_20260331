package com.sum8;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class L13DeptReadDto {
    public static void main(String[] args) {
        String sql="SELECT * FROM DEPT";
        List<L12DeptDto> deptList=new ArrayList<>();
        try (Connection conn=DriverManager.getConnection(Scott.URL,Scott.USERNAME,Scott.PASSWORD);
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
        ){
            while (rs.next()){
                L12DeptDto dept=new L12DeptDto(); //한줄이 있다는 것은 deptDto 객체가 한개 있다는 의미
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                dept.setLoc(rs.getString("loc"));
                deptList.add(dept);
            }
            System.out.println(deptList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
