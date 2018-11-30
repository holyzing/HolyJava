package com.holy.dao.trade;

import java.sql.Timestamp;

/**
 * 商品评论
 * @author holy
 *
 */
public class GoodsComment {
	//用户与商品与订单
	//是否已经审阅 并回复 回复内容
	private Integer gcid; // 主键
	private Integer gid; //商品id
	private Integer uoid; //用户订单id
	private Integer ulid;//用户
	private Integer givenStar;// 评价星星 (标题)
	private String comment; //评论内容 
	private Integer state; //处理状态 （关闭，还是交互中）
	private Timestamp commentTime;//评论时间
	public Integer getGcid() {
		return gcid;
	}
	public void setGcid(Integer gcid) {
		this.gcid = gcid;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public Integer getUoid() {
		return uoid;
	}
	public void setUoid(Integer uoid) {
		this.uoid = uoid;
	}
	public Integer getUlid() {
        return ulid;
    }
    public void setUlid(Integer ulid) {
        this.ulid = ulid;
    }
    public Integer getGivenStar() {
		return givenStar;
	}
	public void setGivenStar(Integer givenStar) {
		this.givenStar = givenStar;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Timestamp getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}
	
}
