package com.holy.model.supply;

import java.sql.Timestamp;

/**
 * 供应商
 * @author holy
 *
 */
public class Supplier {
	private Integer sid; //主键id
	private String name; //供应商名称
	private Integer scale; //供应商类型
	private String code; //供应商编码
	private String corporation; //法人
	private String telephone; //联系电话
	private String bankName; //开户行
	private String bankAccount; //银行开户账号
	private String address;  //供应商地址
	private String corporateState; //合作状态 （1-合作过 2-未合作过 3-正在合作 ）
	private Timestamp modifyTime;//最后一次更新时间
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getScale() {
		return scale;
	}
	public void setScale(Integer scale) {
		this.scale = scale;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCorporation() {
		return corporation;
	}
	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCorporateState() {
		return corporateState;
	}
	public void setCorporateState(String corporateState) {
		this.corporateState = corporateState;
	}
	public Timestamp getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}
}
