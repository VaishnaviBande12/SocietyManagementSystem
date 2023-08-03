import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletResponse;  
import java.sql.*;
public class Login extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
    res.setContentType("Text/html");
    PrintWriter pw=res.getWriter();
    Connection con;
    PreparedStatement st;
    String uname,pass;

    try
    {
        uname=req.getParameter("u");
        pass=req.getParameter("p");

        Class.forName("com.mysql.jdbc.Driver");

        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/society","root","Vaishnavi12");
        String q="select * from register where Username = ? and Password = ?";
        st=con.prepareStatement(q);

        st.setString(1,uname);
        st.setString(2,pass);

        ResultSet rs = st.executeQuery();
        if(rs.next())
        {
            RequestDispatcher ds = req.getRequestDispatcher("AdminMainFrame.html");
            ds.include(req, res);
        }
        else
        {
            RequestDispatcher ds = req.getRequestDispatcher("Login.html");
            ds.include(req, res);
        }

    }
    catch(Exception e)
    {
        pw.print("Error"+e);
    }
}
}
