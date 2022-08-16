
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "userLogin", urlPatterns = {"/userLogin"})
public class userLogin extends HttpServlet {
    
public String username;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        username=request.getParameter("user"); //Extract username

        PrintWriter out=response.getWriter();
        
        try
        {
            /* TODO output your page here. You may use following sample code. */
            
           session=request.getSession();
           session.setAttribute("username",request.getParameter("user")); //Set Attribute
           String username = session.getAttribute("username").toString(); //Extract Username
       
         
         //Display Chat Room
         out.println("<html>  <head> <body bgcolor=\"darkgoldenrod\"> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> <title>Matsapha Municipality Company Profile</title>  </head>");
         out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> <center>");
         out.println("<h2>Hi ");
         out.println(username);
         out.println("<br> Welcome to Our Chatting Section ");
         out.println("</h2><br><hr>");
         out.println("  <body>");
         out.println("      <form name=\"chattingPlatform\" action=\"chattingPlatform\">");
         out.println("Message: <input type=\"text\" name=\"txtMsg\" value=\"\" /><input type=\"submit\" value=\"Send\" name=\"cmdSend\"/>");
         out.println("<br><br> <a href=\"chattingPlatform\">Refresh Page</a>");
         out.println("<br>  <br>");
         out.println("Messages :");
         out.println("<br><br>");
         out.println("<textarea  readonly=\"readonly\"   name=\"txtMessage\" rows=\"20\" cols=\"60\">");
         
                  
         // Retrieve all messages from database
        
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/major_project","root","");
              
                Statement st=con.createStatement();
                 
                ResultSet rs=st.executeQuery("select *from chat_users");
            
                // Print all retrieved messages
                while(rs.next())
                {
                    String messages =rs.getString(1)+ " :: " + rs.getString(2);
                    out.println(messages);
                }
               
                con.close();
            }
            catch(Exception ex1) 
            {
                System.err.println(ex1.getMessage());
            }
         
         out.println("</textarea>");
         out.println("<hr>");
         out.println("</form>");
         out.println("</body>");
         out.println("</html>");
                    

        }
        catch(Exception e)
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Chat Application </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Sevlet failed</h1>");
            out.println("</body>");
            out.println("</html>");
            System.out.println(e);
        }
        
                
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
HttpSession session;
}
