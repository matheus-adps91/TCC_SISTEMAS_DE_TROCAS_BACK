package matheus.adps.com.br.sistemadetrocas.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Strings;

import matheus.adps.com.br.sistemadetrocas.model.Session;
import matheus.adps.com.br.sistemadetrocas.service.SessionService;
import matheus.adps.com.br.sistemasdetrocas.thread.ThreadLocalWithUserContext;

@WebFilter( filterName = "AuthenticationFilter", urlPatterns = {
		"/product-category/*",
		"/product/*",
		"/user/get-by-email/*",
		"/user/update",
		"/user/update-password",
		"/auth/logout"
})
public class AuthFilter
	implements
		Filter
{
	@Autowired
	private SessionService sessionService;
	
	@Override
	public void doFilter(
			final ServletRequest request, 
			final ServletResponse response, 
			final FilterChain chain)
			throws IOException, 
			ServletException
	{
		final HttpServletRequest httpRequest = (HttpServletRequest) request;
		final HttpServletResponse httpResponse = (HttpServletResponse) response;
		final String token = httpRequest.getHeader("token");
		if ( Strings.isNullOrEmpty(token) ) {
			httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido");
			return;
		}
		final Session currentSession = sessionService.getSessionByToken(token);
		if (! sessionService.isValidSession(currentSession) ) {
			httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Sessão inválida, faça o login.");
			return;
		}
		ThreadLocalWithUserContext.setUserContext(currentSession.getUser() );
		try {
			chain.doFilter(httpRequest, httpResponse);
		}
		finally {
			ThreadLocalWithUserContext.removeUserContext();
		}
	}
}