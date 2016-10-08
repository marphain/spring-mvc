package marphain.web.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 
 * Application Lifecycle Listener implementation class AutoListener
 *
 */
@WebListener
public class AutoListener implements ServletContextListener
{

    /**
     * Default constructor.
     */
    public AutoListener()
    {
    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)
    {
    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)
    {
    }

}
