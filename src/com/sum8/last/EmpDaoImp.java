//package com.sum8.last;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class EmpDaoImp implements EmpDao{
//
//    private final Connection con;
//
//    public EmpDaoImp(Connection con) {
//        this.con = con;
//    }
//
//
//    @Override
//    public List<EmpDto> findAll(int deptno) throws SQLException {
//        return List.of();
//    }
//
//    @Override
//    public List<EmpDto> findByDeptno( int deptno) throws SQLException {
//        String sql = """
//                select empno, ename, job, mgr, hiredate, sal, comm, deptno
//                from emp
//                where deptno = ?
//                order by empno
//                """;
//
//        List<EmpDto> list = new ArrayList<>();
//
//        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
//            pstmt.setInt(1, deptno);
//
//            try (ResultSet rs = pstmt.executeQuery()) {
//                while (rs.next()) {
//                    list.add(map(rs));
//                }
//            }
//        }
//
//        return list;
//    }
//
//    @Override
//    public EmpDto findById(int empno) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public int insert( EmpDto emp) throws SQLException {
//        String sql = """
//                insert into emp
//                (empno, ename, job, mgr, hiredate, sal, comm, deptno)
//                values (?, ?, ?, ?, ?, ?, ?, ?)
//                """;
//
//        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
//            pstmt.setInt(1, emp.getEmpno());
//            pstmt.setString(2, emp.getEname());
//            pstmt.setString(3, emp.getJob());
//
//            if (emp.getMgr() == null) {
//                pstmt.setNull(4, Types.NUMERIC);
//            } else {
//                pstmt.setInt(4, emp.getMgr());
//            }
//
//            if (emp.getHiredate() == null) {
//                pstmt.setNull(5, Types.DATE);
//            } else {
//                pstmt.setDate(5, emp.getHiredate());
//            }
//
//            if (emp.getSal() == null) {
//                pstmt.setNull(6, Types.NUMERIC);
//            } else {
//                pstmt.setBigDecimal(6, emp.getSal());
//            }
//
//            if (emp.getComm() == null) {
//                pstmt.setNull(7, Types.NUMERIC);
//            } else {
//                pstmt.setBigDecimal(7, emp.getComm());
//            }
//
//            if (emp.getDeptno() == null) {
//                pstmt.setNull(8, Types.NUMERIC);
//            } else {
//                pstmt.setInt(8, emp.getDeptno());
//            }
//
//            return pstmt.executeUpdate();
//        }
//    }
//
//    @Override
//    public int deleteByEmpno( int empno) throws SQLException {
//        String sql = "delete from emp where empno = ?";
//
//        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
//            pstmt.setInt(1, empno);
//            return pstmt.executeUpdate();
//        }
//    }
//
//    @Override
//    public int deleteByDeptno( int deptno) throws SQLException {
//        String sql = "delete from emp where deptno = ?";
//
//        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
//            pstmt.setInt(1, deptno);
//            return pstmt.executeUpdate();
//        }
//    }
//
//    private EmpDto map(ResultSet rs) throws SQLException {
//        EmpDto dto = new EmpDto();
//
//        dto.setEmpno(rs.getInt("empno"));
//        dto.setEname(rs.getString("ename"));
//        dto.setJob(rs.getString("job"));
//        dto.setMgr(getNullableInt(rs, "mgr"));
//        dto.setHiredate(rs.getDate("hiredate"));
//        dto.setSal(rs.getBigDecimal("sal"));
//        dto.setComm(rs.getBigDecimal("comm"));
//        dto.setDeptno(getNullableInt(rs, "deptno"));
//
//        return dto;
//    }
//
//    private Integer getNullableInt(ResultSet rs, String columnLabel) throws SQLException {
//        int value = rs.getInt(columnLabel);
//        if (rs.wasNull()) {
//            return null;
//        }
//        return value;
//    }
//
//
//}
