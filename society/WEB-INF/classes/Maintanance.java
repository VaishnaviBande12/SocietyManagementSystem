import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Maintanance extends HttpServlet
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
        String q="Select * from reservation where Flat_no = ?";
        st=con.prepareStatement(q);

        st.setInt(1,fno);
    
        ResultSet rs = st.executeQuery();

        pw.println("<html><head><head><meta charset='UTF-8'><link rel=\"stylesheet\" type=\"text/css\" href=\"Maintanance.css\" /><meta http-equiv='X-UA-Compatible' content='IE=edge'><link href='https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css' rel='stylesheet'><meta name='viewport' content='width=device-width, initial-scale=1.0>");
        pw.print("<body>");
       
        if(rs.next())
        {
            int total = rs.getInt(3)+rs.getInt(4)+rs.getInt(5);
            pw.print("<section class='text-gray-600 body-font'><div class='container mx-auto flex flex-col px-5 py-24 justify-center items-center'>");
            pw.print("<div class='flex flex-col text-center w-full mb-20'><h1 class='sm:text-4xl text-3xl font-medium title-font mb-2 text-gray-900'>Maintenance</h1>");
            pw.print("<div class='lg:w-2/3 w-full mx-auto overflow-auto'><table class='table-auto w-full text-left whitespace-no-wrap'><thead><tr><th class='px-4 py-3 title-font tracking-wider font-medium text-gray-900 text-sm bg-gray-100 rounded-tl rounded-bl'>Plan</th>");
            pw.print("<th class='px-4 py-3 title-font tracking-wider font-medium text-gray-900 text-sm bg-gray-100'>Price</th> <th class='w-10 title-font tracking-wider font-medium text-gray-900 text-sm bg-gray-100 rounded-tr rounded-br'></th>");
            pw.print(" </tr></thead><tbody>");
            pw.print("<tr><td class='px-4 py-3 bg-gray-100' >Parking</td><td class='px-4 py-3 text-lg bg-gray-100 text-gray-900'>"+rs.getInt(4)+"</td><td class='w-10 bg-gray-100 text-center'><input name='plan' type='radio'></td></tr>");
            pw.print("<tr><td class='border-t-2 bg-gray-100 border-gray-200 px-4 py-3'>Maintanance</td><td class='border-t-2 bg-gray-100 border-gray-200 px-4 py-3 text-lg text-gray-900'>"+rs.getInt(3)+"</td><td class='border-t-2 border-gray-200 bg-gray-100 w-10 text-center'><input name='plan' type='radio'></td></tr>");
            pw.print("<tr><td class='border-t-2 bg-gray-100 border-gray-200 px-4 py-3'>Event Funds</td><td class='border-t-2 bg-gray-100 border-gray-200 px-4 py-3 text-lg text-gray-900'>"+rs.getInt(5)+"</td><td class='border-t-2 border-gray-200  bg-gray-100 w-10 text-center'><input name='plan' type='radio'></td></tr>");
            pw.print("<tr><td class='border-t-2 bg-gray-100 border-gray-200 px-4 py-3'>Total Amount</td><td class='border-t-2 bg-gray-100 border-gray-200 px-4 py-3 text-lg text-gray-900'>"+total+"</td><td class='border-t-2 border-gray-200 w-10  bg-gray-100 text-center'><input name='plan' type='radio'></td></tr>");
            pw.print("</td></tr></tbody></table>");
            pw.print("<div class='flex pl-4 mt-4 lg:w-2/3 w-full mx-auto'><button class='flex ml-auto text-white bg-indigo-500 border-0 py-2 px-6  focus:outline-none hover:bg-indigo-600 rounded '>Pay</button</div>");
           

        }
    }
    catch(Exception e)
    {

    }
}
}