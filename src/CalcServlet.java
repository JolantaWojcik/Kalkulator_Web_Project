import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		double liczba1 = Double.parseDouble(request.getParameter("liczba1"));
		double liczba2 = Double.parseDouble(request.getParameter("liczba2"));

		String operator = request.getParameter("operator");

		// TODO: refactoring! Strategy

		double wynik = 0;

		if ("+".equals(operator)) {
			wynik = liczba1 + liczba2;
		}
		else if ("-".equals(operator)) {
			wynik = liczba1 - liczba2;
		}
		else if ("*".equals(operator)) {
			wynik = liczba1 * liczba2;
		}
		// ...

		response.setContentType("text/html");
		response.getWriter().println("<b>Wynik to: " + wynik + "</b>");

	}
}
