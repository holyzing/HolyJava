package com.holy.model.goods;

import java.sql.Timestamp;

public class GoodsBrand {
	private Integer gbid; //主键
	private Integer kindid;    //品牌类别 （衣服 ，食品，等）
	private String brandName;    //品牌名称
	private String logoUrl; //logo图片Url
	private String remark; //品牌描述
	private Integer state;     //品牌状态
	private Integer order;    //排序
	private Timestamp modifyTime;//最后一次更新时间
	private String telephone;  //电话号码   有啥意义？
	private String web;        //品牌网络   有啥意义？
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
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
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
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	
}
