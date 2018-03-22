package com.holy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.holy.model.Response;
import com.holy.params.AdvertiserParam;
/**
 * 前后端分离
 * @author hadoop
 *		１：json字符串到java对象称为序列化，java对象到json数据称为反序列化，在行业内统称为序列化
 *		 
 *		{
			"meta": {
				"success": true,
				"message": "ok"
			},
			"data": ...
		}
 */
@Controller
public class TestController {
	@RequestMapping(value = "/advertiser", method = RequestMethod.POST)  
    public Response createAdvertiser(@RequestBody AdvertiserParam advertiserParam) {
		return new Response();
    }
	/**
	 * 将函数返回值序列化
	 * @param advertiserId
	 * @return
	 */
	@RequestMapping(value = "/advertiser/{id}", method = RequestMethod.GET)  
    public @ResponseBody Response getAdvertiser(@PathVariable("id") String advertiserId) { 
		return new Response();
    }  
}
/**
 * 将整个控制器中的方法返回值都序列化
	    @Target({ElementType.TYPE})  
	    @Retention(RetentionPolicy.RUNTIME)  
	    @Documented  
	    @Controller  
	    @ResponseBody  
	    public @interface RestController {  
	        String value() default "";  
	    }  
*/
class AdvertiserController {  
  
    @RequestMapping(value = "/advertiser", method = RequestMethod.POST)  
    public Response createAdvertiser(@RequestBody AdvertiserParam advertiserParam) {  
    	return new Response();
    }  
  /*
   *     <mvc:annotation-driven>  
        <mvc:message-converters>  
            <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter"/>  
        </mvc:message-converters>  
    </mvc:annotation-driven>  
   */
    @RequestMapping(value = "/advertiser/{id}", method = RequestMethod.GET)  
    public Response getAdvertiser(@PathVariable("id") String advertiserId) { 
    	return new Response();
    }  
}  
