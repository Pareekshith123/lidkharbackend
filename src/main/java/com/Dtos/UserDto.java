package com.Dtos;

import org.hibernate.validator.constraints.NotEmpty;

public class UserDto {
    private Integer userId; // Updated variable name
    @NotEmpty
    
    private String userName;
    private String email;
    private String mobileNumber;
    private String password;
    private String about;
    
    public UserDto() {
    }
    
    public UserDto(Integer userId, String userName, String email, String mobileNumber, String password, String about) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.about = about;
    }

    public Integer getUserId() {

        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAbout() {
        return about;
    }
    public void setAbout(String about) {
        this.about = about;
    }

}
