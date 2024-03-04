package com.yezhik_ya.model;

public class User extends BaseEntity
{
    private String name;
    private String lastName;
    private String phone;
    private Long born;
    private String picture;
    private String email;

    public User(String name, String lastName, String phone, Long born, String picture, String email)
    {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.born = born;
        this.picture = picture;
        this.email = email;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Long getBorn() { return born; }
    public void setBorn(Long born) { this.born = born; }
    public String getPicture() { return picture; }
    public void setPicture(String picture) { this.picture = picture; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
