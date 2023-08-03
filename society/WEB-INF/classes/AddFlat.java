import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AddFlat extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
    res.setContentType("Text/html");
    PrintWriter pw=res.getWriter();
    Connection con;
    PreparedStatement st;
    int fno;
    String ftype;

    try
    {
        fno=Integer.parseInt(req.getParameter("f"));
        ftype=req.getParameter("ft");

        //Class.forName("com.mysql.jdbc.Driver");

        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/society","root","Vaishnavi12");
        String q="insert into Flat(Flat_no,Flat_type) values(?,?)";
        st=con.prepareStatement(q);

        st.setInt(1,fno);
        st.setString(2,ftype);

        st.executeUpdate();
        pw.println("<script type='text/javascript'>");
        pw.print("alert('Successfully Added...!');");
        pw.println("location='addFlat.html';");
        pw.println("</script>");

    }
    catch(Exception e)
    {
        pw.print("<h1>Error"+e);
    }
}
}
