package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sql.SqlConnection;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, String> accounts = null;

		try {
			accounts = SqlConnection.getUserPass();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String user = request.getParameter("user");
		String password = request.getParameter("pass");

		PrintWriter writer = response.getWriter();

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		writer.println("<head><title> Account managment</title></head>");
		writer.println("<body>");

		writer.println("<br/>");

		if (accounts.containsKey(user)) {
			if (accounts.get(user).equals(password)) {
				writer.println("Welcome , <b>" + user + "</b>!");
			} else {

				writer.println("Password doesnt match");
				response.sendRedirect("index.html");
			}
		} else {
			writer.println("User <b>" + user + "</b> doesnt exist!");

			response.sendRedirect("index.html");
		}

		writer.println("<br/>");
		writer.println("<br/>");

		writer.println("<form action=\"ProductsServlet\" method=\"post\">");

		writer.println("<label style=\"background-color:lightgray;\" for=\"products\">Choose a product:</label>");

		writer.println("<br/>");
		writer.println("<br/>");
		writer.println("<br/>");

		writer.println("<select id=\"products\" name=\"products\">");

		writer.println("<optgroup label=\"KEYBOARDS\">");
		writer.println("<option value=\"keyboardw\">Wireless Keyboard</option>");
		writer.println("<option value=\"keyboardc\">Cable Keyboard</option>");
		writer.println("</optgroup>");

		writer.println("<optgroup label=\"MOUSES\">");
		writer.println("<option value=\"mousew\">Wireless Mouse</option>");
		writer.println("<option value=\"mousec\">Cable Mouse</option>");
		writer.println("</optgroup>");

		writer.println("<optgroup label=\"PC COMPONENTS\">");
		writer.println("<option value=\"ram\">RAM</option>");
		writer.println("<option value=\"cpu\">CPU</option>");
		writer.println("</optgroup>");

		writer.println("</select>");

		writer.println(" <input type=\"hidden\" name=\"userID\" value=" + user + ">");
		writer.println("<input type=\"submit\" value=\"Choose (Get)\"></input>");
		writer.println("</form>");
		writer.println("</body>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
