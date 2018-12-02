package com.holy.model.user;

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
    private BigDecimal delta;     //变量
    private Integer source;       //变更原因  （充值 体现 付款 退款） （确定相关单据即相关表）
    private Integer sourceSn;     //相关单据id (可以小于零)
    private Timestamp triggerTime; //触发时间
    private BigDecimal balance;    //变更后账户余额
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
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	public BigDecimal getDelta() {
		return delta;
	}
	public void setDelta(BigDecimal delta) {
		this.delta = delta;
	}
	public Integer getSourceSn() {
		return sourceSn;
	}
	public void setSourceSn(Integer sourceSn) {
		this.sourceSn = sourceSn;
	}
	public Timestamp getTriggerTime() {
		return triggerTime;
	}
	public void setTriggerTime(Timestamp triggerTime) {
		this.triggerTime = triggerTime;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
