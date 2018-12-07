package com.holy.model.goods;

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
	private Double delta;    	  //变动量
	private Double storage;       //仓储余量   (货物表也维护)
	private Integer source; //变更原因  （进货） （售货） （退货） （补货）
	private Integer sourceSn;     //相关单据    （进货单，售单）
	private Timestamp triggerTime; //触发时间
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
	public Double getDelta() {
		return delta;
	}
	public void setDelta(Double delta) {
		this.delta = delta;
	}
	public Double getStorage() {
		return storage;
	}
	public void setStorage(Double storage) {
		this.storage = storage;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	public Integer getSourceSn() {
		return sourceSn;
	}
	public void setSourceSn(Integer sourceSn) {
		this.sourceSn = sourceSn;
	}
	public Timestamp getTriggerTime() {
		return triggerTime;
	}
	public void setTriggerTime(Timestamp triggerTime) {
		this.triggerTime = triggerTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
