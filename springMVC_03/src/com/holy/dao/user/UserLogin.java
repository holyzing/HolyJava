package com.holy.dao.user;

import java.sql.Timestamp;

/**
 * 用户名密码登录方式
 * @author holy
 *  1-主键命名规则：取驼峰首字母加id
 *  2-外键命名规则：取主键
 *  3-时间一律用sql中的时间
 *  4-基本类型一律换为包装类型
 *  5-随着业务扩展，数据量的增大，为了保证性能，需要形成分区表
-- -----------------------------------------------------------
-- 用户登录表            （登录业务,用户头像）
-- 用户登录日志表
-- 用户基础信息表   （基础信息查看与修改）
-- 用户账户变动日志表 （账户变动：充值，下单，退款，提现，活动）
-- 用户地址表            （省 市 县（区）详细地址 ，默认（不能修改即为家庭住址）收货地址变动）

-- 用户注册表           （注册业务）
-- 用户关键信息修改日志表   （关键字段修改记录）

-- 平台信息表               （等级 ，积分 ，等级更新时间）
-- 平台积分变动日志表 （增加 减少 ，原因）  
-- 平台等级定义表         （会员级别 级别积分上限，级别积分下限）
-- 用户扩展属性表
-- 用户扩展属性值表
-- _________________ 存储分析 ________________
-- 热数据放到Redis中
-- _________________ 存储分析 ________________
-- 定义一个枚举保存一系列代号的所代表的值
-- -----------------------------------------------------------
     -- 注册 注销  (冷数据)
        -- regist_state
        -- regist_time
        -- regist_addr
        -- regist_age
        -- unregist_time
        -- unregist_addr
        -- unregist_reason
        -- ...
-- --> tb_user_attr                 
        -- attrId                   
        -- attr_name                
        -- attr_type                
        -- attr_minSize             
        -- attr_maxSize             
-- --> tb_user_attr_value           
        -- valueId                  
        -- attrId                   
        -- userId                   
        -- value   
 */
/**
 * 
 * @author holy
 * sessionID token 等
 */
public class UserLogin {
    private Integer ulid;        //主键
    private String loginName;    //登录名
    private String password;     //密码 （最基本的MD5加密）
    private Short loginState;    //登录状态 （登录 断开 登出）
    private String headImageUrl; //头像
    private String token;		 //会话口令 或者说是sessionId
    private Timestamp modifyTime;//心跳刷新时间 
    public Integer getUlid() {
        return ulid;
    }
    public void setUlid(Integer ulid) {
        this.ulid = ulid;
    }
    public String getLoginName() {
        return loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Short getLoginState() {
        return loginState;
    }
    public void setLoginState(Short loginState) {
        this.loginState = loginState;
    }
    public String getHeadImageUrl() {
        return headImageUrl;
    }
    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
    }
	public Timestamp getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
