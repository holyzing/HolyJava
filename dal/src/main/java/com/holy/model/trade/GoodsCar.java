package com.holy.model.trade;

import java.sql.Timestamp;
/**
 * 非金融机构 是否有必要使用BigDecimal
 * @author holy
 */
public class GoodsCar {
	private Integer gcid; //主键
	private Integer ulid; //用户id
	private Integer gid; //商品id （所属商铺） 后期扩展为平台
	private Integer amount;//加入购物车量      数量  卖的时候应该是整量，然后在货物的时候是 double/int
	private Timestamp addTime; //加入时间
	private Timestamp modifyTime;
	public Integer getGcid() {
		return gcid;
	}
	public void setGcid(Integer gcid) {
		this.gcid = gcid;
	}
	public Integer getUlid() {
		return ulid;
	}
	public void setUlid(Integer ulid) {
		this.ulid = ulid;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Timestamp getAddTime() {
		return addTime;
	}
	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}
	public Timestamp getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}
}
