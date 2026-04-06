package com.sum8;

import java.time.LocalDate;
//생성자초기화+toString+equals+get함수 자동생성
public record L18EmpRecord(
        int empno,
        String ename,
        String job,
        Integer mgr,
        LocalDate hiredate,
        Double sal,
        Double comm,
        Integer deptno
) { }
