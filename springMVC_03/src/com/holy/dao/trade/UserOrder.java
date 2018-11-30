package com.holy.dao.trade;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * .用户订单详情页
 * @return
 */
public class UserOrder {
    private Integer uoid;           // 主键
    private Integer lid;            // 新建物流id      
    private Integer uid;            // 用户id
    private Integer uaid;           // 用户所选地址id   -- 省 市 区  邮编 详细地址
    private String streamNum;               // 订单编号                    --  流水号，编号，时间戳
    private Integer payWay;         // 订单支付方式             --  现金，2余额，3网银，4支付宝，5微信',
    private Integer state;          // 订单状态                    --  发起 待支付 等待发货 等待揽收 运输中 正在派件 已收货 （评价） 关闭  
                                    // 发起退款 等
    private Timestamp orderTime;    // 下单时间
    private Timestamp payTime;      // 支付时间
    private Timestamp shipTime;     // 发货时间         //物流
    private Timestamp recieveTime;  // 收货时间        // 物流
    private Timestamp modifyTime;   // 最后一次修改时间      -- 实际上是不允许修改的

    private BigDecimal cost;        // 订单总额
    private BigDecimal discount;    // 折扣金额
    private BigDecimal pay;         // 最后支付

    private String invoice;         // 发票
    private Integer rewardPoints;   // 本次订单所获积分
    public Integer getUoid() {
        return uoid;
    }
    public void setUoid(Integer uoid) {
        this.uoid = uoid;
    }
    public Integer getLid() {
        return lid;
    }
    public void setLid(Integer lid) {
        this.lid = lid;
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
    public String getStreamNum() {
        return streamNum;
    }
    public void setStreamNum(String streamNum) {
        this.streamNum = streamNum;
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
    public Timestamp getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }
    public Timestamp getPayTime() {
        return payTime;
    }
    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }
    public Timestamp getShipTime() {
        return shipTime;
    }
    public void setShipTime(Timestamp shipTime) {
        this.shipTime = shipTime;
    }
    public Timestamp getRecieveTime() {
        return recieveTime;
    }
    public void setRecieveTime(Timestamp recieveTime) {
        this.recieveTime = recieveTime;
    }
    public Timestamp getModifyTime() {
        return modifyTime;
    }
    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }
    public BigDecimal getCost() {
        return cost;
    }
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
    public BigDecimal getDiscount() {
        return discount;
    }
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
    public BigDecimal getPay() {
        return pay;
    }
    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }
    public String getInvoice() {
        return invoice;
    }
    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }
    public Integer getRewardPoints() {
        return rewardPoints;
    }
    public void setRewardPoints(Integer rewardPoints) {
        this.rewardPoints = rewardPoints;
    }
    
}
