package Exception;

import java.util.Scanner;

//exception handling advantages
//1.Maintain the normal flow of program
//2.Meaningful Error reporting

//Exceptions are handle by following keywords
//1.try   2.catch   3.throw   4.throws   5.finally

public class ExceptionHandling {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter A:= ");
		int a = sc.nextInt();
		System.out.println("Enter B:= ");
		int b = sc.nextInt();
		try 
		{
			int c;
			
			 c = a / b;
			System.out.println("A  / B := "+c);
			

		}
		
		catch(ArithmeticException e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
