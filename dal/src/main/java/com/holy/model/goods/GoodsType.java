package com.holy.model.goods;

import java.sql.Timestamp;

/**
 * 货物分类层级
 * @author holy
 *
 *mysql 关键字
 *type
 *order
 *
 */
public class GoodsType {
    private Integer gtid;      //主键
    private String  typeName;  //类型名称
    private Integer root;    //是否是根类型
    private Integer last;    //是否是最终类型
    private Integer fatherId;//父类型
    private Integer rankNum;   //层级

    private String  typeCode;  //类型编码       需要定制一套编码系统 （食品，衣物，交通，工具，数码，等）
    private String  typeState; //类型状态
    private Timestamp modifyTime;//最后一次更新时间
	public Integer getGtid() {
		return gtid;
	}
	public void setGtid(Integer gtid) {
		this.gtid = gtid;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getRoot() {
		return root;
	}
	public void setRoot(Integer root) {
		this.root = root;
	}
	public Integer getLast() {
		return last;
	}
	public void setLast(Integer last) {
		this.last = last;
	}
	public Integer getFatherId() {
		return fatherId;
	}
	public void setFatherId(Integer fatherId) {
		this.fatherId = fatherId;
	}
	public Integer getRankNum() {
		return rankNum;
	}
	public void setRankNum(Integer rankNum) {
		this.rankNum = rankNum;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getTypeState() {
		return typeState;
	}
	public void setTypeState(String typeState) {
		this.typeState = typeState;
	}
	public Timestamp getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}
}
