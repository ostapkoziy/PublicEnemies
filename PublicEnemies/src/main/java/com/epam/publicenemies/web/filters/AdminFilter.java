package com.epam.publicenemies.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class AdminFilter implements Filter
{
	private Logger	log	= Logger.getLogger(AdminFilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		HttpSession session = ((HttpServletRequest) request).getSession();
		if (session.getAttribute("admin") != null)
		{
			chain.doFilter(request, response);
		}
		else
		{
			((HttpServletResponse) response).sendRedirect("index.html");
		}
	}
	@Override
	public void destroy()
	{
	}
}
