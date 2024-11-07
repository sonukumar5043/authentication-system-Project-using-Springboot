package com.RegisationProject.Login.Dto;
public class UserInput {
    private long id;
    private String email;
    private String password;
    
    public UserInput() {
    }
    public UserInput(long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
    public long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "UserInput [id=" + id + ", email=" + email + ", password=" + password + "]";
    }
    
    
}
