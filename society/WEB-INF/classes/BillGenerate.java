import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class BillGenerate extends HttpServlet
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
        fno=Integer.parseInt(req.getParameter("f"));

        Class.forName("com.mysql.jdbc.Driver");

        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/society","root","Vaishnavi12");
        String q="Select * from Charges where Flat_no = ?";
        st=con.prepareStatement(q);

        st.setInt(1,fno);
    
        ResultSet rs = st.executeQuery();
        pw.println("<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"BillGenerate.css\" /></head>");
        pw.print("<body>");
        if(rs.next())
        {
            pw.print("<form class='box' method='Get' action='/society/AddBill'>");
            pw.print(" <h4 style=color:white;>Bill ID <input type=text name='b' value='"+rs.getInt(1)+"' readonly />");
            pw.print(" Flat no <input type=text name='f' value='"+rs.getInt(2)+"' readonly />");
            pw.print(" Maintanance <input type=text name='m' value='"+rs.getInt(3)+"' readonly />");
            pw.print(" Parking Charges<input type=text name='p'value='"+rs.getInt(4)+"' readonly />");
            pw.print(" Event Funds <input type=text name='e' value='"+rs.getInt(5)+"' readonly />");
            pw.print("<input type='Submit' value='Add'>");
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
