package com.zhang.zdg2.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/*"})
public class LoginFilter implements Filter{

	String[] includeUrls = new String[]{"/login/login","/login/register","/login/session"};	
	String messageError="NotLogin";
	
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
        			if(cookie.getName()=="{{$session_key}}") {
        				String sessionId=cookie.getValue();
        				
        				if(sessionId==null) {
        					throw new RuntimeException(messageError);
        				}else {
        					//有id直接转
        					chain.doFilter(servletRequest, servletResponse);
        				}
        			}
        		}
        	}else {
        		throw new RuntimeException(messageError);
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
