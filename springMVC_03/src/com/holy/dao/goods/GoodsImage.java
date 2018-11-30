package com.holy.dao.goods;

import java.sql.Timestamp;

public class GoodsImage {
	private Integer gmid;          //主键
	private Integer gid;           //商品id
	private Integer order;         //图片排序
	private String url;            //url
	private Integer isShow;        //是否生（使用）生效  （包含是否是主图，即显示区域）
	private String remark;         //备注标记 （作为什么来使用）
	private Timestamp modifyTime;  //最后一次更新时间
	//备注描述 没有用
	public Integer getGmid() {
		return gmid;
	}
	public void setGmid(Integer gmid) {
		this.gmid = gmid;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getIsShow() {
		return isShow;
	}
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
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
