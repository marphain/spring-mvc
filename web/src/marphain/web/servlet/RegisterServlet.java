package marphain.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(description = "save user info into db", urlPatterns = {
        "/RegisterServlet" }, initParams={
                @WebInitParam(name="url", value="value")
        })
public class RegisterServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    private Connection connection;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet()
    {
        super();
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException
    {
        try
        {
            //servlet上下文
            //访问根目录下的文件
//            getServletContext().getResourceAsStream("");
            
            ServletContext context = config.getServletContext();
            String user = context.getInitParameter("username");
            String password = context.getInitParameter("password");
            String url = context.getInitParameter("url");
            String driver = context.getInitParameter("driver");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        
    }

    /**
     * @see Servlet#destroy()
     */
    public void destroy()
    {
        if (connection != null)
        {
            try
            {
                connection.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        
        if (connection != null)
        {
            PreparedStatement ps = null;
            try
            {
                String sql = "insert into user(username, password, sex) values(?,?,?)";
                ps = connection.prepareStatement(sql);
                ps.setString(1, userName);
                ps.setString(2, password);
                ps.setString(3, sex);
                ps.executeUpdate();
                ps.close();
                
                PrintWriter out = response.getWriter();
                out.print("<h1 align='center'>");
                out.print(userName + "注册成功！");
                out.print("</h1>");
                out.println("<div align=\"center\">");
                out.println("<a href=\"/web/ManualServlet\">返回</a>");
                out.println("</div>");
                out.flush();
                out.close();                        
            }
            catch (SQLException e)
            {
                if (ps != null)
                {
                    try
                    {
                        ps.close();
                    }
                    catch (SQLException e1)
                    {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            }
        }
    }

}
