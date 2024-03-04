package com.yezhik_ya.model;

import java.io.Serializable;
import java.util.Objects;

public class User extends BaseEntity implements Serializable
{
    private String name;
    private String lastName;
    private String phone;
    private long born;
    private String picture;
    private String email;
    private String password;
    private String retype;

    public User() {}
    public User(String name, String lastName, String phone, long born, String picture, String email, String password, String retype)
    {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.born = born;
        this.picture = picture;
        this.email = email;
        this.password = password;
        this.retype = retype;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Long getBorn() { return born; }
    public void setBorn(long born) { this.born = born; }
    public String getPicture() { return picture; }
    public void setPicture(String picture) { this.picture = picture; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getReType() { return retype; }
    public void setRetype(String reType) { this.retype = reType; }
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return born == user.born && Objects.equals(name, user.name) && Objects.equals(lastName, user.lastName) && Objects.equals(phone, user.phone) && Objects.equals(picture, user.picture) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(retype, user.retype);
    }
}
