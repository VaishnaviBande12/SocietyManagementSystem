import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class SellHouse extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
    res.setContentType("Text/html");
    PrintWriter pw=res.getWriter();
    Connection con;
    PreparedStatement st;
    int fno,sp;

    try
    {
        fno=Integer.parseInt(req.getParameter("fno"));
        sp=Integer.parseInt(req.getParameter("sp"));

        //Class.forName("com.mysql.jdbc.Driver");

        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/society","root","Vaishnavi12");
        String q="insert into sell_house(Flat_no,Sold_price) values(?,?)";
        st=con.prepareStatement(q);

        st.setInt(1,fno);
        st.setInt(2,sp);
        
        st.executeUpdate();
        pw.print("<h1>Data Added..");

    }
    catch(Exception e)
    {
        pw.print("<h1>Error"+e);
    }
}
}
