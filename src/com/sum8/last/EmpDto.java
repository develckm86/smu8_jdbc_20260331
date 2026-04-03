package com.sum8.last;

import java.math.BigDecimal;
import java.sql.Date;

public class EmpDto {
    private int empno;
    private Integer mgr;
    private String ename;
    private String job;
    private String dname;
    private String loc;
    private BigDecimal sal;
    private BigDecimal conn;
    private Date hiredate;

    @Override
    public String toString() {
        return "EmpDto{" +
                "empno=" + empno +
                ", mgr=" + mgr +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                ", sal=" + sal +
                ", conn=" + conn +
                ", hiredate=" + hiredate +
                '}';
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public BigDecimal getConn() {
        return conn;
    }

    public void setConn(BigDecimal conn) {
        this.conn = conn;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }
}
