import java.io.*;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.util.*;

public class Login extends HttpServlet {
		
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try{
		
			String user_id = request.getParameter("user_id");
			String password = request.getParameter("password");			
						
			if(user_id.equals("admin"))	{						
				
			    if(password.equals("admin")){
					HttpSession session=request.getSession();  
					session.setAttribute("currentUser",user_id);
					response.sendRedirect(request.getContextPath()+"/adminhomepage.html");
				}
				else{
					response.sendRedirect(request.getContextPath()+"/invalidlogin.html");
				}				
			}
			else{
				
					HashMap<String, User> userMap = MySQLDataStoreUtilities.getUsers();					
					if(userMap != null){
					  
						User user  = userMap.get(user_id);					
						if(user != null){				
							HttpSession session=request.getSession();  					
							if(user.getPassword().equals(password)){
								if(user.getUserType().equalsIgnoreCase("Customer")){
									session.setAttribute("currentUser",user_id);  
									session.setAttribute("userTypeInfo",user.getUserType());
									response.sendRedirect(request.getContextPath()+"/validlogin.html");
								}
								else if(user.getUserType().equalsIgnoreCase("Salesman")){
									session.setAttribute("currentUser",user_id);  
									session.setAttribute("userTypeInfo",user.getUserType());
									response.sendRedirect(request.getContextPath()+"/salesmanvalidlogin.html");
								}
							}
							else{
								response.sendRedirect(request.getContextPath()+"/invalidlogin.html");
							}
						}
						else{
							response.sendRedirect(request.getContextPath()+"/invalidlogin.html");
						}
						
					}
					else{
						response.sendRedirect(request.getContextPath()+"/loginserverdown.html");
					}
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}

