import java.util.Scanner;

public class Main {
	
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		long executionCount = (long) n*n*n;
        System.out.println(executionCount);
		int degree = 3;
		
		if (degree > 3 || degree < 1) {
            System.out.println(4);
        } else {
            System.out.println(degree);
        }
	}
}
