package com.holy.model.goods;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 商品  (如何对品牌进行分级，归纳)
 * @author holy
 *  （有些内容是要保存到用户本地的，这种技术是缓存技术，缓存标签）
 */
public class Goods {
	private Integer gid;           //主键 	(编码)
	private Integer sid;           //供应商id
	private Integer gt1id;         //一级类型 （上架时的栏目划分的依据）
	private Integer gt2id;         //二级类型 （上架时的栏目划分的依据）
	private Integer gt3id;         //三级类型 （上架时的栏目划分的依据）

	//先别拆开 用sql进行区分 ”改“ 数据 和 ”查“ 数据
	private Double storage;        //库存余量
	private Double waying;         //在途量
	private Double occupying;      //在占用量

	private BigDecimal unitCost;   //进价
	private BigDecimal unitPrice;  //售价
	private BigDecimal disCount;   //当前折扣

	// 这些属性可抽取为一张图片
	private Integer gbid;          //品牌id
	private String name;           //名称
	private String unit;           //计量单位 （枚举，还是自定义）
	private String standard;       //规格
	private String model;          //型号
	private String barCode;        //国条码
	private Double weight;         //商品平均重量
	private Double length;         //商品平均长度
	private Double height;         //商品平均高度
	private Double width;          //商品平均宽度
	private Integer color;         //主色调
	private Timestamp prodcutDate; //生产日期
	private Timestamp shelflife;   //有效期
	private Timestamp indate;      //录入时间

	private Integer showState;     //上下架状态  （如果上架则，则上架区为）

	private Integer verifyState;   //审核状态    (实际意义是 ？)

	// private String code;        //商品编码    (要这个编码干啥)

	private String remark;         //备注 描述
	private Timestamp modifyTime;  //最后一次更新时间

	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public Integer getGbid() {
		return gbid;
	}
	public void setGbid(Integer gbid) {
		this.gbid = gbid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getGt1id() {
		return gt1id;
	}
	public void setGt1id(Integer gt1id) {
		this.gt1id = gt1id;
	}
	public Integer getGt2id() {
		return gt2id;
	}
	public void setGt2id(Integer gt2id) {
		this.gt2id = gt2id;
	}
	public Integer getGt3id() {
		return gt3id;
	}
	public void setGt3id(Integer gt3id) {
		this.gt3id = gt3id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Double getStorage() {
		return storage;
	}
	public void setStorage(Double storage) {
		this.storage = storage;
	}
	public Double getWaying() {
        return waying;
    }
    public void setWaying(Double waying) {
        this.waying = waying;
    }
    public Double getOccupying() {
        return occupying;
    }
    public void setOccupying(Double occupying) {
        this.occupying = occupying;
    }
    public BigDecimal getDisCount() {
        return disCount;
    }
    public void setDisCount(BigDecimal disCount) {
        this.disCount = disCount;
    }
    public String getStandard() {
        return standard;
    }
    public void setStandard(String standard) {
        this.standard = standard;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public BigDecimal getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(BigDecimal unitCost) {
		this.unitCost = unitCost;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public Integer getColor() {
		return color;
	}
	public void setColor(Integer color) {
		this.color = color;
	}
	public Integer getVerifyState() {
		return verifyState;
	}
	public void setVerifyState(Integer verifyState) {
		this.verifyState = verifyState;
	}
	public Integer getShowState() {
		return showState;
	}
	public void setShowState(Integer showState) {
		this.showState = showState;
	}
	public Timestamp getProdcutDate() {
		return prodcutDate;
	}
	public void setProdcutDate(Timestamp prodcutDate) {
		this.prodcutDate = prodcutDate;
	}
	public Timestamp getShelflife() {
		return shelflife;
	}
	public void setShelflife(Timestamp shelflife) {
		this.shelflife = shelflife;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public Timestamp getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

}
