package com.holy.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 由于二级缓存的数据不一定都是存储到内存中，它的存储介质多种多样，
 * 所以需要给缓存的对象执行序列化。如果该类存在父类，那么父类也要实现序列化。
 * @author hadoop
 *
 */
public class User implements Serializable{
    private int id;
    private String username;
    private String sex;
    private Date birthday;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", sex=" + sex
                + ", birthday=" + birthday + ", address=" + address + "]";
    }
}