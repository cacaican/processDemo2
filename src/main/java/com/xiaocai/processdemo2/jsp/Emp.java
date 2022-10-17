package com.xiaocai.processdemo2.jsp;

/**
 * @description:
 * @author: xiaocai
 * @time: 2022/10/14 10:19
 */
public class Emp {
    private String empId;
    private String empName;
    private String password;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
