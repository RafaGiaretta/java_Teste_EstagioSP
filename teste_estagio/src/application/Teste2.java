package application;

import java.util.Scanner;

public class Teste2 {

	public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
			System.out.println("Entre com um numero: ");
			int n = sc.nextInt();
			
			if(pertenceF(n) == 1) {
				System.out.println("O numero " + n + " pertence a sequencia de Fibonacci");
			}
			else {
				System.out.println("O numero " + n + " nao pertence a sequencia de Fibonacci");
			}			
			
			
			sc.close();
	}	
	
	public static int pertenceF(int n) {
		int a = 0; 
		int b = 1;
		int c = 0;	
		
		if (a == n || b == n ) {
			return 1;
		}
		while (b < n) {
			c = a + b ;
			a = b;
			b = c;
			if (b ==n)
				return 1;			
		}
		return 0;
	}

}