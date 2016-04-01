import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class SumTwoNumbers {

	public static void main(String[] args) {
		
		int a;
		int b;
		int sum;
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Please enter two integers a and b:");
		
		System.out.print("Enter a = ");
		a = input.nextInt();
		
		System.out.print("Enter b = ");
		b = input.nextInt();
		
		sum = a+b;
		
		System.out.println("Sum of the two numbers is:  " + a + " + " + b + " = " + sum);
		
		input.close();
	}
	
	
}
