package com.bitcamp.op.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		
		//세션확인(세션이 있는지 없는지) 
		
		//-> return true : 정상적인 컨트롤러 실행
		//-> retrun false : 로그인페이지로 다시 이동
		
		//세션안에 true면 새로운 세션을 생성함
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			
			//세션을 반환하면 object타입 loginInfo세션이 있는지 불러옴
			Object object = session.getAttribute("loginInfo");
			
			//세션이 있다면(로그인되어있다면)
			if(object != null) {
				
				return true;
			}
			
		}
		//세션이 없다면(로그인되어있지 않다면)
		response.sendRedirect(request.getContextPath() + "/member/login");
		return false;
	}

	
	
}
