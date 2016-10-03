import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebInitParam;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	double wynik;
	double liczba1;
	double liczba2;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		String operator = request.getParameter("operator");
		if(liczba1!=0 && liczba2!=0){
			double liczba1 = Double.parseDouble(request.getParameter("liczba1"));
			double liczba2 = Double.parseDouble(request.getParameter("liczba2"));
		}
	
		// TODO: refactoring! Strategy
		if(operator!=null){
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
		}
		response.setContentType("text/html");
		response.getWriter().println("<b>Wynik to: " + wynik + "</b>");
		response.getWriter().println("<b>Wynik to: " + operator + "</b>");
	}
}
