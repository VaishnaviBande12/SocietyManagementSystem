import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Register extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
    res.setContentType("Text/html");
    PrintWriter pw=res.getWriter();
    Connection con;
    PreparedStatement st;
    int rid;
    String fname,uname,email,pass,mno;

    try
    {
        fname=req.getParameter("f");
        uname=req.getParameter("u");
        mno=req.getParameter("m");
        email=req.getParameter("e");
        pass=req.getParameter("p");

        //Class.forName("com.mysql.jdbc.Driver");

        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/society","root","Vaishnavi12");
        String q="insert into register(Full_name,Username,Mobile_no,Email,Password) values(?,?,?,?,?)";
        st=con.prepareStatement(q);

        st.setString(1,fname);
        st.setString(2,uname);
        st.setString(3,mno);
        st.setString(4,email);
        st.setString(5,pass);

        st.executeUpdate();
        RequestDispatcher ds = req.getRequestDispatcher("Login.html");
        ds.include(req, res);

    }
    catch(Exception e)
    {
        pw.print("<h1>Error"+e);
    }
}
}
