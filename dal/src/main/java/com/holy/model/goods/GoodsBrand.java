package com.holy.model.goods;

import java.sql.Timestamp;

public class GoodsBrand {
	private Integer gbid; //主键
	private Integer kindid;    //品牌类别 （衣服 ，食品，等）
	private String brandName;    //品牌名称
	private String brandLogo; //logo图片Url
	private String brandDesc; //品牌描述
	private Integer brandState;     //品牌状态
	private Integer brandOrder;    //排序
	private Timestamp modifyTime;//最后一次更新时间
	private String telephone;  //电话号码   有啥意义？
	private String brandWeb;        //品牌网络   有啥意义？
	public Integer getGbid() {
		return gbid;
	}
	public void setGbid(Integer gbid) {
		this.gbid = gbid;
	}
	public Integer getKindid() {
		return kindid;
	}
	public void setKindid(Integer kindid) {
		this.kindid = kindid;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getBrandLogo() {
		return brandLogo;
	}
	public void setBrandLogo(String brandLogo) {
		this.brandLogo = brandLogo;
	}
	public String getBrandDesc() {
		return brandDesc;
	}
	public void setBrandDesc(String brandDesc) {
		this.brandDesc = brandDesc;
	}
	public Integer getBrandState() {
		return brandState;
	}
	public void setBrandState(Integer brandState) {
		this.brandState = brandState;
	}
	public Integer getBrandOrder() {
		return brandOrder;
	}
	public void setBrandOrder(Integer brandOrder) {
		this.brandOrder = brandOrder;
	}
	public Timestamp getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getBrandWeb() {
		return brandWeb;
	}
	public void setBrandWeb(String brandWeb) {
		this.brandWeb = brandWeb;
	}
}
