package com.holy.dao.user;

import java.sql.Timestamp;

/**
 * 用户地址表
 * @author holy
 *
 */
public class UserAddr {
    private Integer uaid;         //主键
    private Integer ulid;         //登录id
    private Integer zip;          //邮编
    private Integer provice;      //省份编号
    private Integer city;         //城市编号
    private Integer area;         //区县编号
    private String specific;      //具体地址
    private Integer isDefault;    //是否默认
    private Integer state;        //是否删除

    //这两项有是否选择当前登录用户的选项
    private String consignee;     //收货人
    private String telephone;     //收货人电话号码

    private Timestamp modifyTime; //最后修改时间
    public Integer getUaid() {
		return uaid;
	}
	public void setUaid(Integer uaid) {
		this.uaid = uaid;
	}
	public Integer getUlid() {
        return ulid;
    }
    public void setUlid(Integer ulid) {
        this.ulid = ulid;
    }
    public Integer getZip() {
        return zip;
    }
    public void setZip(Integer zip) {
        this.zip = zip;
    }
    public Integer getProvice() {
        return provice;
    }
    public void setProvice(Integer provice) {
        this.provice = provice;
    }
    public Integer getCity() {
        return city;
    }
    public void setCity(Integer city) {
        this.city = city;
    }
    public Integer getArea() {
        return area;
    }
    public void setArea(Integer area) {
        this.area = area;
    }
    public String getSpecific() {
        return specific;
    }
    public void setSpecific(String specific) {
        this.specific = specific;
    }
    public Integer getIsDefault() {
        return isDefault;
    }
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    public String getConsignee() {
        return consignee;
    }
    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public Timestamp getModifyTime() {
        return modifyTime;
    }
    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }
}
