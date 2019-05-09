package customersApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApplicationServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	res.setContentType("text/plain; charset=utf-8");
	try {
		Driver driver = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driver);
		Connection connection = driver.connect("jdbc:mysql://localhost/baza?user=root:password=password", null);
		Statement statement = connection.createStatement();
		if(statement.execute("SELECT * FROM customerList")) {
			ResultSet list = statement.getResultSet();
			while (list.next());
			res.getWriter().printf(list.getString("name"), list.getString("surname"), list.getString("phoneNr"), list.getString("mailAddres"));
		}
		connection.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
}
}

