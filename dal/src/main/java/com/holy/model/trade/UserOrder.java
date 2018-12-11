package com.holy.model.trade;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * .用户订单详情页
 * @return
 */
public class UserOrder {
    private Integer uoid;           // 主键
    private Integer uid;            // 用户id
    private Integer uaid;           // 用户所选地址id   -- 省 市 区  邮编 详细地址
    private Integer lid;            // 新建物流id      
    private String orderSn;               // 订单编号                    --  流水号，编号，时间戳
    private Integer payWay;         // 订单支付方式             --  现金，2余额，3网银，4支付宝，5微信',
    private Integer state;          // 订单状态                    --  发起 待支付 等待发货 等待揽收 运输中 正在派件 已收货 （评价） 关闭  // 发起退款 等
                                    
    private Timestamp createTime;    // 下单时间
    private Timestamp payTime;       // 支付时间

    private BigDecimal order_money;        // 订单总额
    private BigDecimal discount_money;    // 折扣金额
    private BigDecimal pay_money;         // 最后支付

    private String invoiceTitle;         // 发票
    private Integer rewardPoint;   // 本次订单所获积分
    private Timestamp modifyTime;   // 最后一次修改时间      -- 实际上是不允许修改的
	public Integer getUoid() {
		return uoid;
	}
	public void setUoid(Integer uoid) {
		this.uoid = uoid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getUaid() {
		return uaid;
	}
	public void setUaid(Integer uaid) {
		this.uaid = uaid;
	}
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public String getOrderSn() {
		return orderSn;
	}
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}
	public Integer getPayWay() {
		return payWay;
	}
	public void setPayWay(Integer payWay) {
		this.payWay = payWay;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getPayTime() {
		return payTime;
	}
	public void setPayTime(Timestamp payTime) {
		this.payTime = payTime;
	}
	public BigDecimal getOrder_money() {
		return order_money;
	}
	public void setOrder_money(BigDecimal order_money) {
		this.order_money = order_money;
	}
	public BigDecimal getDiscount_money() {
		return discount_money;
	}
	public void setDiscount_money(BigDecimal discount_money) {
		this.discount_money = discount_money;
	}
	public BigDecimal getPay_money() {
		return pay_money;
	}
	public void setPay_money(BigDecimal pay_money) {
		this.pay_money = pay_money;
	}
	public String getInvoiceTitle() {
		return invoiceTitle;
	}
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}
	public Integer getRewardPoint() {
		return rewardPoint;
	}
	public void setRewardPoint(Integer rewardPoint) {
		this.rewardPoint = rewardPoint;
	}
	public Timestamp getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}
}
