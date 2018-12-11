package com.holy.model.trade;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author holy
 */
public class Logistical {
    // 物流单号  运费金额  
	private Integer lid;           // 主键
	private Integer sid;           // staffid 员工id 处理员工
	private String shippingSn;     // 运单号
	private BigDecimal shippingMoney;       // 运费
	private String remark;         // 备注描述
	private Timestamp createTime;  // 创建时间
	// 发货时间
	// 收货时间
	// 物流公司名称等
	// 发货地址
	// 收货地址等
	private Timestamp modifyTime;  // 最后一次更新时间
	// 从物流单号中获取快递提供的接口：
	// 接手快递员 接手快递员号码 派件员 派件员电话号码
    public Integer getLid() {
        return lid;
    }
    public void setLid(Integer lid) {
        this.lid = lid;
    }
    public Integer getSid() {
        return sid;
    }
    public void setSid(Integer sid) {
        this.sid = sid;
    }
    public String getShippingSn() {
		return shippingSn;
	}
	public void setShippingSn(String shippingSn) {
		this.shippingSn = shippingSn;
	}
	public BigDecimal getShippingMoney() {
		return shippingMoney;
	}
	public void setShippingMoney(BigDecimal shippingMoney) {
		this.shippingMoney = shippingMoney;
	}
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Timestamp getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    public Timestamp getModifyTime() {
        return modifyTime;
    }
    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }
	
//  .每个订单的物流信息， 而至于和物流公司的合作关系则是需要平台端处理, 而且似乎没必要建表，就那么几家物流.
//  private String name;           //公司名称
//  private String contact;        //常用负责人
//  private String telephone;      //常用负责人联系电话
//  private Integer state;         //合作状态 （合作过已解约等等）
//  private BigDecimal price;      //合作价格
}
