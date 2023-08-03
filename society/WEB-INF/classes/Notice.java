import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Notice extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
    res.setContentType("Text/html");
    PrintWriter pw=res.getWriter();
    Connection con;
    PreparedStatement st;
    int fno;

    try
    {

        Class.forName("com.mysql.jdbc.Driver");

        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/society","root","Vaishnavi12");
        String q="Select * from notice";
        st=con.prepareStatement(q);
    
        ResultSet rs = st.executeQuery();
        pw.println("<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"BillGenerate.css\" /></head>");
        pw.print("<body>");
        if(rs.next())
        {
            pw.print("<form class='box' method='Get'>");
            pw.print(" <h4 style=color:white;>Todays Notice <input type=text name='b' value='"+rs.getString(2)+"' readonly />");
            pw.print("</h4>");
            pw.print("</form>");
            

        }
        else
        {
            pw.print("Error");
        }


    }
    catch(Exception e)
    {
        pw.print("<h1>Error"+e);
    }
}
}
