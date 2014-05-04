package local.tux.core.webapp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MenuContextListener implements ServletRequestListener {

	Log log = LogFactory.getLog(MenuContextListener.class);
	

	

	@Override
	public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
		log.info(servletRequestEvent.getServletContext());
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent servletRequestEvent) {
		// TODO Auto-generated method stub
		
	}

	

}
