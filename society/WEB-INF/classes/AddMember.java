import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AddMember extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
    res.setContentType("Text/html");
    PrintWriter pw=res.getWriter();
    Connection con;
    PreparedStatement st;
    int fno;
    String fname,city,email,add,room,gender,pno;

    try
    {
        fname=req.getParameter("f");
        fno=Integer.parseInt(req.getParameter("fno"));
        pno=req.getParameter("pno");
        email=req.getParameter("e");
        city=req.getParameter("c");
        room=req.getParameter("r"); 
        gender=req.getParameter("g");

        //Class.forName("com.mysql.jdbc.Driver");

        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/society","root","Vaishnavi12");
        String q="insert into Member(Full_name,Flat_no,Phone_no,Email,city,Room,Gender) values(?,?,?,?,?,?,?)";
        st=con.prepareStatement(q);

        st.setString(1,fname);
        st.setInt(2,fno);
        st.setString(3,pno);
        st.setString(4,email);
        st.setString(5,city);
        st.setString(6,room);
        st.setString(7,gender);


        st.executeUpdate();
        pw.println("<script type='text/javascript'>");
        pw.print("alert('Successfully Added...!');");
        pw.println("location='addmember.html';");
        pw.println("</script>");

    }
    catch(Exception e)
    {
        pw.print("<h1>Error"+e);
    }
}
}
