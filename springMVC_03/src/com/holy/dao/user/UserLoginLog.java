package com.holy.dao.user;

import java.sql.Timestamp;

/**
 * 用户登录日志
 * @author holy
 *
 */
public class UserLoginLog {
    private Integer ullid;         //登录日志id
    private Integer ulid;          //登录id
    private Integer loginWay;        //登录方式   （用户名登录）（手机号登录） （邮箱登录） （应用号授权登录）
    private Integer loginIp;         //登录IP
    private String loginMachine;   //登录终端标识  什么手机/什么类型 比如 小米手机
    private Timestamp loginTime;   //登录时间
    private Integer loginResult;     //登录结果  （成功 失败：名字不对  密码不对  不存在）
    private String loginAddr;      //登录地点  (通过高德或者百度或者腾讯定位获得)
    private Integer logoutReason;    //下线原因  (主动下线, 失去心跳，响应超时)
    private Timestamp logoutTime;  //下线时间
    private String logoutIp;       //登出Ip
    public Integer getUllid() {
        return ullid;
    }
    public void setUllid(Integer ullid) {
        this.ullid = ullid;
    }
    public Integer getUlid() {
        return ulid;
    }
    public void setUlid(Integer ulid) {
        this.ulid = ulid;
    }
    public Integer getLoginWay() {
        return loginWay;
    }
    public void setLoginWay(Integer loginWay) {
        this.loginWay = loginWay;
    }
    public Integer getLoginIp() {
        return loginIp;
    }
    public void setLoginIp(Integer loginIp) {
        this.loginIp = loginIp;
    }
    public String getLoginMachine() {
        return loginMachine;
    }
    public void setLoginMachine(String loginMachine) {
        this.loginMachine = loginMachine;
    }
    public Timestamp getLoginTime() {
        return loginTime;
    }
    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }
    public Integer getLoginResult() {
        return loginResult;
    }
    public void setLoginResult(Integer loginResult) {
        this.loginResult = loginResult;
    }
    public Integer getLogoutReason() {
        return logoutReason;
    }
    public void setLogoutReason(Integer logoutReason) {
        this.logoutReason = logoutReason;
    }
    public Timestamp getLogoutTime() {
        return logoutTime;
    }
    public void setLogoutTime(Timestamp logoutTime) {
        this.logoutTime = logoutTime;
    }
    public String getLoginAddr() {
        return loginAddr;
    }
    public void setLoginAddr(String loginAddr) {
        this.loginAddr = loginAddr;
    }
    public String getLogoutIp() {
        return logoutIp;
    }
    public void setLogoutIp(String logoutIp) {
        this.logoutIp = logoutIp;
    }
}
