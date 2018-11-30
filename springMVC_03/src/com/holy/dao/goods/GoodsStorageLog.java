package com.holy.dao.goods;

import java.sql.Timestamp;

/**
 * 仓库存储日志
 * @author holy
 *
 */
public class GoodsStorageLog {
	/**
        '仓库ID',
    '当前商品数量',
  '当前占用数据',
  '在途数据',
  '移动加权成本',
	 */
	private Integer gslid;        //主键
	private Integer gid;          //货物id
	private Double storage;       //仓储余量   (货物表也维护)
	private Double delta;    	  //变动量
	private Integer changeReason; //变更原因  （进货） （售货） （退货） （补货）
	private Timestamp happenTime; //触发时间
	private Integer abountId;     //相关单据    （进货单，售单）
	private String remark;//备注
	public Integer getGslid() {
		return gslid;
	}
	public void setGslid(Integer gslid) {
		this.gslid = gslid;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public Double getStorage() {
		return storage;
	}
	public void setStorage(Double storage) {
		this.storage = storage;
	}
	public Double getDelta() {
		return delta;
	}
	public void setDelta(Double delta) {
		this.delta = delta;
	}
	public Integer getChangeReason() {
		return changeReason;
	}
	public void setChangeReason(Integer changeReason) {
		this.changeReason = changeReason;
	}
	public Timestamp getHappenTime() {
		return happenTime;
	}
	public void setHappenTime(Timestamp happenTime) {
		this.happenTime = happenTime;
	}
	public Integer getAbountId() {
		return abountId;
	}
	public void setAbountId(Integer abountId) {
		this.abountId = abountId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
