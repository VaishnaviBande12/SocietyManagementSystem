import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AddBill extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
    res.setContentType("Text/html");
    PrintWriter pw=res.getWriter();
    Connection con;
    PreparedStatement st;
    int main,pc,ef,total;

    try
    {
        pw.println("<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"BillGenerate.css\" /></head>");
        pw.print("<body>");
        main=Integer.parseInt(req.getParameter("m"));
        pc=Integer.parseInt(req.getParameter("p"));
        ef=Integer.parseInt(req.getParameter("e"));
        pw.print("<form class='box'>");
        total = main + pc + ef;
        pw.print(" <h4 style=color:white;>Total Maintanance <input type=text name='t' value='"+total+"' readonly /></h4>");

    }
    catch(Exception e)
    {
        pw.print("<h1>Error"+e);
    }
}
}
