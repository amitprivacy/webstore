package com.amit.webstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ProcessingTimeLogInterceptor implements HandlerInterceptor {

	private static final Logger LOGGER = Logger.getLogger(ProcessingTimeLogInterceptor.class);
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Long startTime=System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		System.out.println("Requested URL: "+request.getRequestURL());
		String requestedResource = request.getRequestURI();
		System.out.println(requestedResource);
		System.out.println(request.getContextPath());
		System.out.println(request.getQueryString());
//		if(request.getRequestURI().equals("/webstore/products/add"))
//		{
//			System.out.println("You can't add products on Thursday");
//			return false;
//		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		String queryString = request.getQueryString()==null?"":"?"+request.getQueryString();
		
		String path = request.getRequestURL()+queryString;
		
		long startTime = (Long)request.getAttribute("startTime");
		
		long endTime = System.currentTimeMillis();
		
		LOGGER.info(String.format("%s milliseconds taken to prcess the request %s",(endTime-startTime),path));

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
