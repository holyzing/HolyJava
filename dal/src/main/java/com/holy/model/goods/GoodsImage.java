package com.holy.model.goods;

import java.sql.Timestamp;

public class GoodsImage {
	private Integer giid;          //主键
	private Integer gid;           //商品id
	private Integer sequence;         //图片排序
	private String url;            //url
	private Integer state;        //是否生（使用）生效  （包含是否是主图，即显示区域）
	private String description;         //备注标记 （作为什么来使用）
	private Timestamp modifyTime;  //最后一次更新时间
	//备注描述 没有用
	public Integer getGiid() {
		return giid;
	}
	public void setGiid(Integer giid) {
		this.giid = giid;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}
}
