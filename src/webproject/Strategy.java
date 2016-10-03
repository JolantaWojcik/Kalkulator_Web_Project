package webproject;

public class Strategy{
	public Operations operation;

	public double calculate(double liczba1, double liczba2){
		return operation.calculate(liczba1, liczba2);
	}
	public void setOperationType(Operations o){
		operation = o;
	}
	 public Strategy(Operations o){
	      operation =o;
	   }
}
