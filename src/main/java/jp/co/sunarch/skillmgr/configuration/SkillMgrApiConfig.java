package jp.co.sunarch.skillmgr.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.handler.MappedInterceptor;

import jp.co.sunarch.skillmgr.controller.SkillMgrApiCommonProcess;

@Configuration
public class SkillMgrApiConfig {

	@Bean
	public SkillMgrApiCommonProcess skillMgrApiCommonProcess() {
		return new SkillMgrApiCommonProcess();
	}

	@Bean
	public MappedInterceptor interceptor() {
		return new MappedInterceptor(new String[] { "/**" }, skillMgrApiCommonProcess());
	}

	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {
		CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
		filter.setIncludeClientInfo(true);
		filter.setIncludeQueryString(true);
		filter.setIncludeHeaders(true);
		filter.setIncludePayload(true);
		filter.setMaxPayloadLength(10240);
		return filter;
	}
}
