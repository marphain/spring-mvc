package marphain.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet(description = "my first servlet", urlPatterns = { "/AutoServlet" })
public class AutoServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoServlet()
    {
        super();
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
        
    }

    /**
     * @see Servlet#destroy()
     */
    public void destroy()
    {
        super.destroy();
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        super.service(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        ServletConfig config = super.getServletConfig();
        
        String info = super.getServletInfo();
        
        Enumeration<String> names = config.getInitParameterNames();
        ServletContext context = config.getServletContext();
        
        PrintWriter out = response.getWriter();
        out.println("servlet-info:" + info);
        out.println(". servlet-name:" + config.getServletName());
        out.println(". names:");
        while(names.hasMoreElements())
        {
            out.println(names.nextElement());
        }
        
        out.println(". context-path:" + context.getContextPath());
        
        out.println(". auto servlet!");
        
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

}
