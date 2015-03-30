package v2.web;

import v2.push.BroadCaster;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

@WebListener
public class CleanupContextListener extends AbstractServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        BroadCaster.close();
    }
}
