package marphain.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManualServlet extends HttpServlet
{
    private int calledTimes = 0;
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        //设置编码格式，正常输出中文
        resp.setCharacterEncoding("UTF-8");
        
        //设置客户端解码格式
        resp.setHeader("content-type", "text/html;charset=UTF-8");
//        resp.setContentType("text/html;charset=UTF-8");
        
//        OutputStream os = resp.getOutputStream();
//        os.write("你好，世界！".getBytes());
        
        PrintWriter out = resp.getWriter();
        
        //注册页面
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<div>");
        out.println("<form action='/web/RegisterServlet' method='post'>");
        out.println("<table border='1'>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<td colspan='2' align='center'>servlet注册</td>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        out.println("<tr>");
        out.println("<td>用户名：</td>");
        out.println("<td><input type='text' name='userName'></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>密码：</td>");
        out.println("<td><input type='password' name='password'></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>性别：</td>");
        out.println("<td>");
        out.println("<input type='radio' name='sex' checked='checked' value='male'>male");
        out.println("<input type='radio' name='sex' value='female'>female");
        out.println("</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td colspan='2' align='center'>");
        out.println("<input type='submit' value='注册'>");
        out.println("<input type='reset' value='重置'>");
        out.println("</td>");
        out.println("</tr>");
        out.println("</tbody>");
        out.println("</table>");
        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        super.doGet(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        System.out.println("service() called, times is : " + ++this.calledTimes);
        super.service(req, resp);
    }

    @Override
    public void destroy()
    {
        System.out.println("destroy() called!");
        super.destroy();
    }

    @Override
    public void init() throws ServletException
    {
        System.out.println("init() called!");
        
        //获取本servlet的配置参数
        ServletConfig config = getServletConfig();
        String configParam = config.getInitParameter("configParam");
        System.out.println("servlet config:" + configParam);
    }
    
}
