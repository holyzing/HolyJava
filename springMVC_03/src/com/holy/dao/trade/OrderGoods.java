package com.holy.dao.trade;

import java.sql.Timestamp;

/**
 *  活动会有活动表
 * @author holy

  product_name VARCHAR(50) NOT NULL COMMENT '商品名称',
  product_price DECIMAL(8,2) NOT NULL COMMENT '购买商品单价',
  average_cost DECIMAL(8,2) NOT NULL COMMENT '平均成本价格',
  weight FLOAT COMMENT '商品重量',
  fee_money DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '优惠分摊金额',
  w_id INT UNSIGNED NOT NULL COMMENT '仓库ID',
  
 */
public class OrderGoods {
    private Integer ogid;   //主键 （订单商品详情）
    private Integer uoid;   //订单id
    private Integer gid;    //商品id  
    private Double amount;  //本次订单出售该商品数量
    private String remark;  //本次订单备注
    //最后一次修改时间 (而事实上是不允许被修改的！)
    private Timestamp modifyTime;
    public Integer getOgid() {
        return ogid;
    }
    public void setOgid(Integer ogid) {
        this.ogid = ogid;
    }
    public Integer getUoid() {
        return uoid;
    }
    public void setUoid(Integer uoid) {
        this.uoid = uoid;
    }
    public Integer getGid() {
        return gid;
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
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Timestamp getModifyTime() {
        return modifyTime;
    }
    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }
}
