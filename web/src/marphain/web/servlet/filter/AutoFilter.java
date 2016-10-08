package marphain.web.servlet.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class AutoFilter
 */
@WebFilter(description = "my first filter", urlPatterns = {
        "/AutoFilter" }, initParams = {
                @WebInitParam(name = "count", value = "5000") })
public class AutoFilter implements Filter
{

    /**
     * Default constructor.
     */
    public AutoFilter()
    {
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy()
    {
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException
    {
        // TODO Auto-generated method stub
        // place your code here

        // pass the request along the filter chain
        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException
    {
    }

}
