package customersApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApplicationServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	res.setContentType("text/plain; charset=utf-8");
	PrintWriter printWriter = res.getWriter();
	printWriter.println("LISTA");
}
}

