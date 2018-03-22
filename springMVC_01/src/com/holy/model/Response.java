package com.holy.model;
/**
 * 
 * @author hadoop
 *包括两类通用返回值消息：ok与error，
 *包括两个常用的操作方法：success( )与failure( )，
 *通过一个内部类来展现元数据结构
 */
public class Response {  
    
    private static final String OK = "ok";  
    private static final String ERROR = "error";  
  
    private Meta meta;  
    private Object data;  
  
    public Response success() {  
        this.meta = new Meta(true, OK);  
        return this;  
    }  
  
    public Response success(Object data) {  
        this.meta = new Meta(true, OK);  
        this.data = data;  
        return this;  
    }  
  
    public Response failure() {  
        this.meta = new Meta(false, ERROR);  
        return this;  
    }  
  
    public Response failure(String message) {  
        this.meta = new Meta(false, message);  
        return this;  
    }  
  
    public Meta getMeta() {  
        return meta;  
    }  
  
    public Object getData() {  
        return data;  
    }  
  
    public class Meta {  
  
        private boolean success;  
        private String message;  
  
        public Meta(boolean success) {  
            this.success = success;  
        }  
  
        public Meta(boolean success, String message) {  
            this.success = success;  
            this.message = message;  
        }  
  
        public boolean isSuccess() {  
            return success;  
        }  
  
        public String getMessage() {  
            return message;  
        }  
    }  
}  
