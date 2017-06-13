package com.zrkc.model;

/**
 * Created by YaoZiHao on 2017/6/12.
 */
public class Emp {
    private int empno;
    private String ename;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    private String job;
    private  Double salary;
    private  Integer dno;
    private Integer age;
    private String sex;

    public Emp() {
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", job='" + job + '\'' +
                ", salary='" + salary + '\'' +
                ", dno=" + dno +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }


    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getDno() {
        return dno;
    }

    public void setDno(Integer dno) {
        this.dno = dno;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
