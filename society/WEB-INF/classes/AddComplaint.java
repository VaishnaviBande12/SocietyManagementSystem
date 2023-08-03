import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AddComplaint extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
    res.setContentType("Text/html");
    PrintWriter pw=res.getWriter();
    Connection con;
    PreparedStatement st;
    String notice;

    try
    {
        notice=req.getParameter("n");

        //Class.forName("com.mysql.jdbc.Driver");

        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/society","root","Vaishnavi12");
        String q="insert into Complaint(Complaint) values(?)";
        st=con.prepareStatement(q);

        st.setString(1,notice);

        st.executeUpdate();
        pw.println("<script type='text/javascript'>");
        pw.print("alert('Successfully Added...!');");
        pw.println("location='addcomplaint.html';");
        pw.println("</script>");

    }
    catch(Exception e)
    {
        pw.print("<h1>Error"+e);
    }
}
}
