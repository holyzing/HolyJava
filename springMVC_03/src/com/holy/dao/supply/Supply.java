package com.holy.dao.supply;

import java.sql.Timestamp;

/**
 * 供应商
 * @author holy
 *
 */
public class Supply {
	private Integer gsid; //主键id
	private String name; //供应商名称
	private Integer type; //供应商类型
	private String code; //供应商编码
	private String corporation; //法人
	private String telephone; //联系电话
	private String bank; //开户行
	private String bankNum; //银行开户账号
	private String state; //合作状态 （1-合作过 2-未合作过 3-正在合作 ）
	private String address;  //供应商地址
	private Timestamp modifyTime;//最后一次更新时间
	public Integer getGsid() {
		return gsid;
	}
	public void setGsid(Integer gsid) {
		this.gsid = gsid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
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
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getBankNum() {
		return bankNum;
	}
	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}
	
}
