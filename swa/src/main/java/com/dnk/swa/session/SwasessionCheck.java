package com.dnk.swa.session;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SwasessionCheck implements HttpSessionListener{
	
	private static final Logger logger = LoggerFactory.getLogger(SwasessionCheck.class);

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().setMaxInactiveInterval(20);
		logger.info(" session : " + se.getSession().getCreationTime());
		logger.info(" session : " + se.getSession().getLastAccessedTime());
		logger.info(" session : " + se.getSession().getAttributeNames());
		se.getSession().removeAttribute("level");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
	}
	
	
	

}
