import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AddCharges extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
    res.setContentType("Text/html");
    PrintWriter pw=res.getWriter();
    Connection con;
    PreparedStatement st;
    int fno,maintanance,pc,ef;

    try
    {
        fno=Integer.parseInt(req.getParameter("f"));
        maintanance=Integer.parseInt(req.getParameter("m"));
        pc=Integer.parseInt(req.getParameter("p"));
        ef=Integer.parseInt(req.getParameter("e"));

        //Class.forName("com.mysql.jdbc.Driver");

        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/society","root","Vaishnavi12");
        String q="insert into charges(Flat_no,Maintanance,Parking_Charges,Event_Funds) values(?,?,?,?)";
        st=con.prepareStatement(q);

        st.setInt(1,fno);
        st.setInt(2,maintanance);
        st.setInt(3,pc);
        st.setInt(4,ef);

        st.executeUpdate();
        pw.println("<script type='text/javascript'>");
        pw.print("alert('Successfully Added...!');");
        pw.println("location='addcharges.html';");
        pw.println("</script>");

    }
    catch(Exception e)
    {
        pw.print("<h1>Error"+e);
    }
}
}
