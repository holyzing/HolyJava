package com.holy.dao.user;

import java.math.BigDecimal;
import java.sql.Timestamp;
/**
 * 用户账户表
 * @author holy
 *
 */
public class UserAccountLog {
    private Integer ualid;        //主键
    private Integer ulid;         //登录id
    private Integer changeReason; //变更原因  （充值 体现 付款 退款） （确定相关单据）
    private BigDecimal delta;     //变量
    private Integer aboutId;      //相关单据id (可以小于零)
    private Timestamp happenTime; //触发时间
    private BigDecimal account;   //变更后账户余额
    public Integer getUalid() {
        return ualid;
    }
    public void setUalid(Integer ualid) {
        this.ualid = ualid;
    }
    public Integer getUlid() {
        return ulid;
    }
    public void setUlid(Integer ulid) {
        this.ulid = ulid;
    }
    public Integer getChangeReason() {
        return changeReason;
    }
    public void setChangeReason(Integer changeReason) {
        this.changeReason = changeReason;
    }
    
    public BigDecimal getDelta() {
		return delta;
	}
	public void setDelta(BigDecimal delta) {
		this.delta = delta;
	}
	public Integer getAboutId() {
        return aboutId;
    }
    public void setAboutId(Integer aboutId) {
        this.aboutId = aboutId;
    }
    public Timestamp getHappenTime() {
        return happenTime;
    }
    public void setHappenTime(Timestamp happenTime) {
        this.happenTime = happenTime;
    }
    public BigDecimal getAccount() {
        return account;
    }
    public void setAccount(BigDecimal account) {
        this.account = account;
    }
}
