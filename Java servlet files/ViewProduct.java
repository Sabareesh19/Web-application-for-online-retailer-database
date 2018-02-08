

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewProduct
 */
@WebServlet("/ViewProduct")
public class ViewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String store_id = MySQLDataStoreUtilities.check_inventory((String) (request.getSession().getAttribute("currentUser")));
		HashMap<Integer, Product> store_product = MySQLDataStoreUtilities.getProductsForStore(store_id);
		PrintWriter out = response.getWriter();
		
   		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
		   				
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Welcome</h2>");
		out.println("<br>");
		out.println("Below are the product info at your store");
		out.println("<br>");
		out.println("All products available at the store");
		out.println("<br>");
		for(int j=0;j<store_product.size();j++) {
			out.println("product id : "+store_product.get(j).getProduct_id()+", product name : "+store_product.get(j).getProduct_name()+", price : "+store_product.get(j).getPrice()+", Current Quantity : "+store_product.get(j).getQuantity());
			out.println("<br>");
		}
		out.println("</body>");
		out.println("</html>");
	}

}
