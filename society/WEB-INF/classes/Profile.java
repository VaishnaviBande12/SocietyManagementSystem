import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Profile extends HttpServlet
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
        String q="Select * from Member where Flat_no = ?";
        st=con.prepareStatement(q);

        st.setInt(1,fno);
    
        ResultSet rs = st.executeQuery();
        pw.println("<html><head><head><meta charset='UTF-8'><link rel=\"stylesheet\" type=\"text/css\" href=\"Profile.css\" /><meta http-equiv='X-UA-Compatible' content='IE=edge'><link href='https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css' rel='stylesheet'><meta name='viewport' content='width=device-width, initial-scale=1.0>");
        pw.print("<body>");
       
        if(rs.next())
        {
            pw.print("<section class='text-gray-600 body-font'><div class='container mx-auto flex flex-col px-5 py-24 justify-center items-center'>");
            pw.print("<div class='w-full md:w-2/3 flex flex-col mb-5 items-center text-center'><h1 class='title-font sm:text-4xl text-3xl mb-4 bg-gray-100 font-medium text-gray-900 '>"+rs.getString(2)+"</h1></div></div>");
            pw.print(" <div class='container px-5 mx-auto'><div class='flex flex-col text-center w-full mb-2'>");
            pw.print(" <h1 class='sm:text-3xl text-2xl font-medium title-font mb-4 bg-gray-100 text-gray-900'>About</h1>");
            pw.print("<div class='flex flex-wrap -m-4 text-center'><div class='p-4 md:w-1/4 sm:w-1/2 w-full'><div class='border-2  border-gray-200 px-4 py-6 rounded-lg'><path d='M17 21v-2a4 4 0 00-4-4H5a4 4 0 00-4 4v2'></path><circle cx='9' cy='7' r='4'></circle><path d='M23 21v-2a4 4 0 00-3-3.87m-4-12a4 4 0 010 7.75'></path></svg><h2 class='title-font  font-medium text-3xl'>"+rs.getInt(3)+"</h2>");
            pw.print("<p class='leading-relaxed '>Flat No</p></div></div>");
            pw.print("<div class='p-4 md:w-1/4 sm:w-1/2 w-full'><div class='border-2 border-gray-200 px-4 py-6 rounded-lg'><path d='M3 18v-6a9 9 0 0118 0v6'></path><path d='M21 19a2 2 0 01-2 2h-1a2 2 0 01-2-2v-3a2 2 0 012-2h3zM3 19a2 2 0 002 2h1a2 2 0 002-2v-3a2 2 0 00-2-2H3z'></path></svg><h2 class='title-font font-medium text-3xl '>"+rs.getString(8)+"</h2>");
            pw.print("<p class='leading-relaxed'>Flat Type</p></div></div>");
            pw.print("<div class='p-4 md:w-1/4 sm:w-1/2 w-full'><div class='border-2 border-gray-200 px-4 py-6 rounded-lg'><path d='M3 18v-6a9 9 0 0118 0v6'></path><path d='M21 19a2 2 0 01-2 2h-1a2 2 0 01-2-2v-3a2 2 0 012-2h3zM3 19a2 2 0 002 2h1a2 2 0 002-2v-3a2 2 0 00-2-2H3z'></path></svg><h2 class='title-font font-medium text-3xl '>"+rs.getString(4)+"</h2>");
            pw.print("<p class='leading-relaxed'>Phone No</p></div></div>");
            pw.print("<div class='p-4 md:w-1/4 sm:w-1/2 w-full'><div class='border-2 border-gray-200 px-4 py-6 rounded-lg'><path d='M3 18v-6a9 9 0 0118 0v6'></path><path d='M21 19a2 2 0 01-2 2h-1a2 2 0 01-2-2v-3a2 2 0 012-2h3zM3 19a2 2 0 002 2h1a2 2 0 002-2v-3a2 2 0 00-2-2H3z'></path></svg><h2 class='title-font font-medium text-3xl '>"+rs.getString(6)+"</h2>");
            pw.print("<p class='leading-relaxed'>City</p></div></div>");
            pw.print("</div>");
            

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
