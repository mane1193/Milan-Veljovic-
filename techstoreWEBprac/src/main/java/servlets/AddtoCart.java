package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import constructor.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sql.SqlParams;

public class AddtoCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddtoCart() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		String key = request.getParameter("products");
		int number = Integer.valueOf(key);
		String user = request.getParameter("userID");

		Map<Integer, Product> productsMap = new HashMap<Integer, Product>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(SqlParams.url, SqlParams.user, SqlParams.pass);

			LocalDate currentDate = LocalDate.now();
			Date sqlDate = Date.valueOf(currentDate);

			String sql1 = "SELECT user_ID FROM users WHERE username = ?";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setString(1, user);
			ResultSet rs1 = ps1.executeQuery();

			while (rs1.next()) {
				int userID = rs1.getInt("user_ID");

				String sql = "SELECT product_ID, name, price, description FROM products WHERE product_ID = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, number);
				ResultSet rs = ps.executeQuery();

				String sqlAdd = "INSERT INTO orders (user_ID, order_date, product_ID, price) VALUES (?, ?, ?, ?)";
				PreparedStatement psAdd = con.prepareStatement(sqlAdd);

				while (rs.next()) {
					int productID = rs.getInt("product_ID");
					String name = rs.getString("name");
					String description = rs.getString("description");
					Double price = rs.getDouble("price");

					Product product = new Product(name, description, price);

					productsMap.put(productID, product);

					psAdd.setInt(1, userID);
					psAdd.setDate(2, sqlDate);
					psAdd.setInt(3, number);
					psAdd.setDouble(4, product.getPrice());
					psAdd.executeUpdate();
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		writer.println("<body style=\"background-color:powderblue;\">");

		writer.println("<h2 style=\"text-align:center;\">Order details </h2>");

		writer.println("<p><b> Your CART</p>");
		writer.println("</br>");
		writer.println("<p><b>Username: " + request.getParameter("userID"));
		writer.println("</br>");

		writer.println("</br>");
		productsMap.forEach((k, v) -> {
			writer.println("<p><b>Product:" + v + "</b></p>");

		});

		writer.println("<br/>");
		writer.println("</body>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
