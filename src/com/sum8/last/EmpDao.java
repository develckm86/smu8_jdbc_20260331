package com.sum8.last;

import java.sql.*;
import java.util.List;


public interface EmpDao {
    
    List<EmpDto> findAll( int deptno ) throws SQLException;

    List<EmpDto> findByDeptno( int deptno ) throws SQLException;

    EmpDto findById( int empno ) throws SQLException;

    int insert( EmpDto emp ) throws SQLException;

    int deleteByEmpno( int empno ) throws SQLException;

    int deleteByDeptno( int deptno ) throws SQLException;

}
