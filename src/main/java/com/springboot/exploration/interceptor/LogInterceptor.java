package com.springboot.exploration.interceptor;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.exploration.constant.Constants;

/**
 * Login Intercepter is class that checks if user is logged in or not before
 * Forwarding request to controller.
 * 
 * @author Naveen Tyagi
 *
 */
@Service
public class LogInterceptor implements HandlerInterceptor {

	Logger log = Logger.getLogger(LogInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3)
			throws Exception {
		log.info("Request Completed!");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView model)
			throws Exception {
		log.info("Method executed");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

		if (((String) request.getSession().getAttribute(Constants.LOGGED_USER) != null)) {
			response.sendRedirect("/profile");
			return true;
		} else {
			if (!(Arrays.stream(Constants.excludeUrl).parallel().anyMatch(request.getRequestURI()::contains))) {
				return true;
			}
			return true;
		}
	}
}
