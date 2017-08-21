package com.songxinjing.erp.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.songxinjing.erp.service.ConfigService;
import com.songxinjing.erp.service.UserService;

/**
 * 全局拦截器
 * 
 * @author songxinjing
 * 
 */
@Component
public class GlobalInterceptor implements HandlerInterceptor {

	@Autowired
	ConfigService configService;

	@Autowired
	UserService userService;

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelView) throws Exception {
		// List<Config> configs = configService.findEnable();
		// for (Config c : configs) {
		// modelView.addObject(c.getName(), c.getValue());
		// }

		// User loginUser =
		// (User)request.getSession().getAttribute(Constant.SESSION_LOGIN_USER);

		modelView.addObject("version", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
	}
}
