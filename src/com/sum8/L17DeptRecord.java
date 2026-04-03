package com.sum8;
class Dept {
    private int deptno;
    private String dname;
    private String loc;
    public Dept(int deptno, String dname, String loc){
        this.deptno=deptno; //초기값이 없는 상수는 생성자 호출시 변경 가능
        this.dname=dname;
        this.loc=loc;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
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

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
    //상수는 생성 이후에는 변경 불가
//    public void setDeptno(int deptno){
//        this.deptno=deptno;
//    }
}

public record L17DeptRecord(
    int deptno, //매개변수를 선언하면 레코드 필드로 private final 로 생성됨
    String dname,
    String loc
) { }

class TestApp{ //record 와 dto 생성의 차이를 비교하는 테스트 앱
    public static void main(String[] args) {
        //77번부서, bigdata, 서울
        L17DeptRecord deptRecord=new L17DeptRecord(77,"bigdata","서울");
        System.out.println(deptRecord);
        System.out.println(deptRecord.dname()); //레코드가 자동으로 생성하는 Get 함수
        System.out.println(deptRecord.loc());
        //값을 중간에 변경 불가 (final 이기 때문),
        // dto 는 보통 필드를 final 로 정의하지 않기 때문에 set 함수로 변경


        Dept deptDto =new Dept(77,"bigdata","서울");
        System.out.println(deptDto);//com.sum8.Dept@533ddba
//        System.out.println(deptDto.dname);
        System.out.println(deptDto.getDname());
        deptDto.setDname("빅데이터");
        System.out.println(deptDto.getDname());
    }
}