package br.com.arthur.implementacaoh2.configuration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.CommonsRequestLoggingFilter;

public class CustomeRequestLoggingFilter extends CommonsRequestLoggingFilter {

	@Override
	protected void beforeRequest(HttpServletRequest request, String message) {
		logger.info(message);
	}

	public CustomeRequestLoggingFilter() {
		super.setIncludeQueryString(true);
		super.setIncludePayload(true);
		super.setMaxPayloadLength(10000);
		super.setIncludeHeaders(true);
		
		super.setAfterMessagePrefix("REQUEST2 DATA : ");
	}
}
