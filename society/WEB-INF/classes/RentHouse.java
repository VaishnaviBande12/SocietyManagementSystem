import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class RentHouse extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
    res.setContentType("Text/html");
    PrintWriter pw=res.getWriter();
    Connection con;
    PreparedStatement st;
    int fno,rp;
    String ra;

    try
    {
        fno=Integer.parseInt(req.getParameter("fno"));
        rp=Integer.parseInt(req.getParameter("rp"));
        ra=req.getParameter("ra");

        //Class.forName("com.mysql.jdbc.Driver");

        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/society","root","Vaishnavi12");
        String q="insert into rent_house(Flat_no,Rent_price,Rent_agreement) values(?,?,?)";
        st=con.prepareStatement(q);

        st.setInt(1,fno);
        st.setInt(2,rp);
        st.setString(3,ra);

        st.executeUpdate();
        pw.print("<h1>Data Added..");

    }
    catch(Exception e)
    {
        pw.print("<h1>Error"+e);
    }
}
}
