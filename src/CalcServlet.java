import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	double wynik;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		double liczba1 = Double.parseDouble(request.getParameter("liczba1"));
		double liczba2 = Double.parseDouble(request.getParameter("liczba2"));

		String operator = request.getParameter("operator");

		// TODO: refactoring! Strategy
		if(operator.equals("-")){
			//gdyby bylo wiecej klas
			//wynik = strategy.setOperationType(new SubstractNumbers());
			Strategy s = new Strategy(new SubstractNumbers());
			wynik = s.calculate(liczba1, liczba2);
		}
		if(operator.equals("+")){
			//gdyby bylo wiecej klas
			//wynik = strategy.setOperationType(new SubstractNumbers());
			Strategy s = new Strategy(new AddNumbers());
			wynik = s.calculate(liczba1, liczba2);
		}
		if(operator.equals("*")){
			//gdyby bylo wiecej klas
			//wynik = strategy.setOperationType(new SubstractNumbers());
			Strategy s = new Strategy(new MultiplyNumbers());
			wynik = s.calculate(liczba1, liczba2);
		}
		if(operator.equals("/")){
			//gdyby bylo wiecej klas
			//wynik = strategy.setOperationType(new SubstractNumbers());
			Strategy s = new Strategy(new DivideNumbers());
			wynik = s.calculate(liczba1, liczba2);
		}
		
		response.setContentType("text/html");
		response.getWriter().println("<b>Wynik to: " + wynik + "</b>");

	}
}
