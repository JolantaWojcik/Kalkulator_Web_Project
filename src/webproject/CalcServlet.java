package webproject;
import java.io.IOException;
import java.io.PrintWriter;

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
		
		liczba1 = Double.parseDouble(request.getParameter("liczba1"));
		liczba2 = Double.parseDouble(request.getParameter("liczba2"));
	
		// TODO: refactoring! Strategy
		if(operator!=null){
			if(operator.equals("-")){
				//gdyby bylo wiecej klas
				//wynik = strategy.setOperationType(new SubstractNumbers());
				Strategy s = new Strategy(new SubstractNumbers());
				wynik = s.calculate(liczba1, liczba2);
			}
			if(operator.equals("+")){
				Strategy s = new Strategy(new AddNumbers());
				wynik = s.calculate(liczba1, liczba2);
			}
			if(operator.equals("*")){
				Strategy s = new Strategy(new MultiplyNumbers());
				wynik = s.calculate(liczba1, liczba2);
			}
			if(operator.equals("/")){
				Strategy s = new Strategy(new DivideNumbers());
				wynik = s.calculate(liczba1, liczba2);
			}
		}
		
		response.getWriter().println("<br>Operator to: " + operator + "</br>");
		response.getWriter().println("<br>liczba1 to: " + liczba1 + "</br>");
		response.getWriter().println("<br>liczba2 to: " + liczba2 + "</br>");
		response.getWriter().println("<br>Wynik to: " + wynik + "</br>");
	}
	
	 // Redirect POST request to GET request.
	   @Override
	   public void doPost(HttpServletRequest request, HttpServletResponse response)
	               throws IOException, ServletException {
	      doGet(request, response);
	   }
}
