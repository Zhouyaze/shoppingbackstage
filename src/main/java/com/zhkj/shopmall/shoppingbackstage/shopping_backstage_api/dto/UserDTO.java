package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.dto;

import java.util.List;

public class UserDTO {
    private String name;//用户名
    private String loginUser;//登陆账号
    private String password;//密码
    private String phoneNumber;//手机号
    private String roleValue;//角色
    private Integer departmentId;
    private String email;//邮箱
    private String date;//最后一次登陆时间
    private List<DepartmentFunctionDto> departmentFunctionDtos;//功能集合

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRoleValue() {
        return roleValue;
    }

    public void setRoleValue(String roleValue) {
        this.roleValue = roleValue;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<DepartmentFunctionDto> getDepartmentFunctionDtos() {
        return departmentFunctionDtos;
    }

    public void setDepartmentFunctionDtos(List<DepartmentFunctionDto> departmentFunctionDtos) {
        this.departmentFunctionDtos = departmentFunctionDtos;
    }
}
