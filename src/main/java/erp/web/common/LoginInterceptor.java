package erp.web.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	/**
	 * 로그인 전 처리
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {			
		HttpSession session=request.getSession();
		if(session.getAttribute("LOGIN")==null) {		
			response.sendRedirect(request.getContextPath()+"/member/login.do");			
			return false;
		}
		return true;
	}
	
	
	/**
	 * 로그인 후 처리
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//logger.info("postHandle................");
	}
	

	
}
