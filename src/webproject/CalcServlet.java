package webproject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebInitParam;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Map<String, Operations> operationsMap;
	
	@Override
	public void init() throws ServletException {
		operationsMap = new HashMap<>();
		operationsMap.put("-", new SubstractNumbers());
		operationsMap.put("+", new AddNumbers());
		operationsMap.put("*", new MultiplyNumbers());
		operationsMap.put("/", new DivideNumbers());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		double wynik;
		double liczba1;
		double liczba2;
		
		response.setContentType("text/html");
		String operator = request.getParameter("operator");
		String l1 = request.getParameter("liczba1");
		String l2 = request.getParameter("liczba2");
		
		liczba1 = Double.parseDouble(request.getParameter("liczba1"));
		liczba2 = Double.parseDouble(request.getParameter("liczba2"));
		
		wynik = operationsMap.get(operator).calculate(liczba1, liczba2);
		
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
