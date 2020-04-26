package vaalikone;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.sql.jdbc.Connection;
import com.google.cloud.sql.jdbc.PreparedStatement;

@WebServlet(
    name = "MD5",
    urlPatterns = {"/login"}
)
public class MD5 extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {

    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");
    
    
    
    
    
    
    
    
    
//    
//    Connection connection;
//    PreparedStatement ps;
//    try {
//        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/vaalikone", "root", "Ranchero979797");
//        ps = connection.prepareStatement("SELECT `username`, `password` FROM `users` WHERE `username` = ? AND `password` = ?");
//        ps.setString(1, request.getParameter("username"));
//        ps.setString(2, request.getParameter("password"));
//        ResultSet result = ps.executeQuery();
//        if(result.next()){
//        	response.sendRedirect("/Ohjauspaneeli.html");
//        }
//        else{
//        	response.getWriter().print("V��r� tunnukset");
//        }
//    } catch (Exception e) {
//       System.err.println("Got an exception! ");
//    	System.err.println(e.getMessage());
//    }
    
    
    
    
    
    
    
    
    

    
    String adminusername = "admin";
    String adminpassword = "admin";
	String admincryptedpassword = crypt(adminpassword);
   
    
    if (request.getParameter("password").equals(admincryptedpassword) && request.getParameter("username").equals(adminusername)) {
    	response.sendRedirect("Ohjauspaneeli");
    }
    else if (request.getParameter("password") != admincryptedpassword || request.getParameter("username") != adminusername) {
    	response.getWriter().print("Väärät tunnukset");
    }
    
    
    
     
  		
		
		
		System.out.println("Your crypted password is " + admincryptedpassword);
		
  }
		
		
		
	private String getParameter(String string) {
	// TODO Auto-generated method stub
	return null;
}

	public static String crypt(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String to encript cannot be null or zero length");
        }

        MessageDigest digester;
        try {
            digester = MessageDigest.getInstance("MD5");

            digester.update(str.getBytes());
            byte[] hash = digester.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                if ((0xff & hash[i]) < 0x10) {
                    hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
                } else {
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
                }
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
	
	
}

