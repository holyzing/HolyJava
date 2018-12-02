package com.holy.model.user;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * 用户基础信息   
 * @author holy
 * 伴生用户信息变更日志  （变更属性  变更时间   原值   新值）
 * 
 * 有没有在该表维护账户的同时在账户变动中维护账户，同理，商品仓储与变化是否需要同时维护
 */
public class UserInfor {
    private Integer uiid;    //主键
    private Integer ulid;    //登录id
    private String username; //用户名称 (真实名称)
    private Integer gender;//性别
    private Date birthday;   //生日
    private String phone;    //手机号码
    private String email;    //邮箱
    private String idType;   //证件类型
    private String idNum;    //证件号码
    private BigDecimal balance;    //账户余额   伴生账户更新日志

    private Integer userGainPoint; //用户积分   伴生积分变动日志
    private Integer userRank;      //用户级别   伴生级别定义 （积分上下限区分级别）
    //（写sql时注意区分出去）


    private Integer registState;       //注册状态   (后期可提出到注册表中)
    private Timestamp registTime;      //注册时间
    private Timestamp writeoffTime; //注销时间
    private Timestamp modifyTime;  //最后修改时间
    public Integer getUiid() {
        return uiid;
    }
    public void setUiid(Integer uiid) {
        this.uiid = uiid;
    }
    public Integer getUlid() {
        return ulid;
    }
    public void setUlid(Integer ulid) {
        this.ulid = ulid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Integer getGender() {
        return gender;
    }
    public void setGender(Integer gender) {
        this.gender = gender;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getIdType() {
        return idType;
    }
    public void setIdType(String idType) {
        this.idType = idType;
    }
    public String getIdNum() {
        return idNum;
    }
    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }
    public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public Integer getUserGainPoint() {
        return userGainPoint;
    }
    public void setUserGainPoint(Integer userGainPoint) {
        this.userGainPoint = userGainPoint;
    }
    public Integer getUserRank() {
        return userRank;
    }
    public void setUserRank(Integer userRank) {
        this.userRank = userRank;
    }
    public Timestamp getModifyTime() {
        return modifyTime;
    }
    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }
    public Integer getRegistState() {
        return registState;
    }
    public void setRegistState(Integer registState) {
        this.registState = registState;
    }
    public Timestamp getWriteoffTime() {
		return writeoffTime;
	}
	public void setWriteoffTime(Timestamp writeoffTime) {
		this.writeoffTime = writeoffTime;
	}
	public Timestamp getRegistTime() {
        return registTime;
    }
    public void setRegistTime(Timestamp registTime) {
        this.registTime = registTime;
    }
}