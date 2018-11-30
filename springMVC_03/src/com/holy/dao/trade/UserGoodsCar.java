package com.holy.dao.trade;

import java.math.BigDecimal;
import java.sql.Timestamp;
/**
 * 非金融机构 是否有必要使用BigDecimal
 * @author holy
 *
 */
public class UserGoodsCar {
	private Integer ugcid; //主键
	private Integer ulid; //用户id
	private Integer gid; //商品id （所属商铺） 后期扩展为平台
	private Double amount;//加入购物车量
	private BigDecimal unitPrice;//单价
	private Timestamp intoTime; //加入时间
	private Timestamp modifyTime;
	public Integer getUgcid() {
		return ugcid;
	}
	public void setUgcid(Integer ugcid) {
		this.ugcid = ugcid;
	}
	public Integer getGid() {
		return gid;
	}
	public Integer getUlid() {
        return ulid;
    }
    public void setUlid(Integer ulid) {
        this.ulid = ulid;
    }
    public void setGid(Integer gid) {
		this.gid = gid;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Timestamp getIntoTime() {
		return intoTime;
	}
	public void setIntoTime(Timestamp intoTime) {
		this.intoTime = intoTime;
	}
    public Timestamp getModifyTime() {
        return modifyTime;
    }
    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }
}
