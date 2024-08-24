package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import constructor.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sql.SqlConnection;

/**
 * Servlet implementation class ProductsServlet
 */
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ProductsServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<Integer, Product> productsMap = null;

		PrintWriter writer = response.getWriter();

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");


		writer.println("<body style=\"background-color:powderblue;\">");

		writer.println("<br/>");

		writer.println("<br/>");
		writer.println("<br/>");

		if (request.getParameter("products").equals("keyboardw")) {
			try {
				productsMap = SqlConnection.getWkeyboard();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			writer.println("<h2 style=\"text-align:center;\">Wireless KEYBOARD</h2>");
		}

		else if (request.getParameter("products").equals("keyboardc")) {
			try {
				productsMap = SqlConnection.getCkeyboard();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			writer.println("<h2 style=\"text-align:center;\">Cable KEYBOARD</h2>");
		}

		else if (request.getParameter("products").equals("mousew")) {
			try {
				productsMap = SqlConnection.getWmouse();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			writer.println("<h2 style=\"text-align:center;\">Wireless Mouse</h2>");
		}

		else if (request.getParameter("products").equals("mousec")) {
			try {
				productsMap = SqlConnection.getCmouse();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			writer.println("<h2 style=\"text-align:center;\">Cable Mouse</h2>");
		}

		writer.println("<br/>");
		writer.println("<br/>");
		writer.println("<br/>");

		String user = request.getParameter("userID");
		productsMap.forEach((k, v) -> {
			writer.println("<p><b>" + v + "</b></p>");
		});

		writer.println("<br/>");

		writer.println("<br/>");
		writer.println("<br/>");
		writer.println("<form action=\"AddtoCart\" method=\"post\">");
		writer.println("<select id=\"products\" name=\"products\">");
		for (Map.Entry<Integer, Product> entry : productsMap.entrySet()) {
			Product product = entry.getValue();
			writer.println("<option value=" + entry.getKey() + ">" + product.getName() + ":    - $" + product.getPrice()
					+ "</option>");
		}

		writer.println("</select>");
		writer.println(" <input type=\"hidden\" name=\"userID\" value=" + user + ">");
		writer.println("<input type=\"submit\" value=\"Add to Cart\"></input>");

		writer.println("</form>");
		writer.println("</body>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
