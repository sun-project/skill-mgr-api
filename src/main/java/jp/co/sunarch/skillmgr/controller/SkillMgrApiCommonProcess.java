package jp.co.sunarch.skillmgr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SkillMgrApiCommonProcess implements HandlerInterceptor {

	org.springframework.web.client.RestTemplate aa;

	private Log logger = LogFactory.getLog(SkillMgrApiCommonProcess.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("★★☆★★☆");
		logger.info("handler:" + handler.getClass());
		if(handler instanceof org.springframework.web.method.HandlerMethod) {
			HandlerMethod h = (HandlerMethod)handler;

			logger.debug(h.getBean());
			for(MethodParameter p : h.getMethodParameters()) {
				logger.debug(p.getParameterName() + ":" + p);
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model)
			throws Exception {
		logger.info("★★☆★★☆");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		// なし
	}
}
