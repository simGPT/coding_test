import java.util.Scanner;

public class Main {
	
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		//(n-1)+(n-2)+(n-3)+...+1 = n(n-1)/2
		long executionCount = (long) n*(n-1)/2;
        System.out.println(executionCount);
		int degree = 2;
		
		if (degree > 3 || degree < 1) {
            System.out.println(4);
        } else {
            System.out.println(degree);
        }
	}
}