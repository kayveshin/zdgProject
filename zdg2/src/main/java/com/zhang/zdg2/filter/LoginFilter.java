package com.zhang.zdg2.filter;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.zhang.zdg2.config.DataConfig;
import com.zhang.zdg2.util.RedisUtil;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/*"})
public class LoginFilter implements Filter{

	@Resource
	RedisUtil redisUtil;
	
	String[] includeUrls = new String[]{"/login/login","/login/register","/login/session"};	
	String NotLoginError="NotLogin";
	String ExpireError="LoginExpire";
	String AgentError="NotSameAgent";
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
		
        
        //判断是否要过滤
        String uri = request.getRequestURI();
        boolean needFilter = isNeedFilter(uri);
        System.out.println(needFilter);
        if(!needFilter) {
        	chain.doFilter(servletRequest, servletResponse);
        }else {
        	Cookie[] cookies=request.getCookies();
        	if(cookies!=null) {
        		for (Cookie cookie : cookies) {
        			if(cookie.getName().equals(DataConfig.SESSIONKEY)) {
        				String sessionId=cookie.getValue();
        				
        				if(sessionId==null) {
        					throw new RuntimeException(NotLoginError);
        				}else {
        					//对比redis中的内容
        					if(redisUtil.hasKey(cookie.getValue())) {
        						if(redisUtil.Lget(DataConfig.SESSIONKEY, 2).equals(request.getHeader("User-Agent"))) {
        							chain.doFilter(servletRequest, servletResponse);
        						}else {
        							throw new RuntimeException(AgentError);
        						}
        						
        					}else {
        						throw new RuntimeException(ExpireError);
        					}
        					
        				}
        			}
        		}
        	}else {
        		throw new RuntimeException(NotLoginError);
        	}
            
        }
        
        
	}
	
	public boolean isNeedFilter(String uri) {
		
		System.out.println(uri);
        for (String includeUrl : includeUrls) {
        	System.out.println(includeUrl);
            if(includeUrl.equals(uri)) {
            	
                return false;
            }
        }

        return true;
    }

}
