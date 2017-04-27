package xtu.library.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import xtu.library.entity.Administrator;
import xtu.library.entity.Reader;
import xtu.library.web.exception.NullSessionException;

public class SystemSessionInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Reader reader = (Reader) session.getAttribute("reader");
		Administrator admin = (Administrator) session.getAttribute("admin");
		if(reader == null && admin == null){
			throw new NullSessionException();
		}
		return true;
	}

}
