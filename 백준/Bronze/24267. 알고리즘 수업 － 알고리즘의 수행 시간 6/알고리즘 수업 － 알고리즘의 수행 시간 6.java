import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        // 안전한 계산 방식 적용 (오버플로우 방지)
        long executionCount = (long) n * (n - 1) / 2 * (n - 2) / 3;
        System.out.println(executionCount);

        int degree = 3;

        if (degree > 3 || degree < 1) {
            System.out.println(4);
        } else {
            System.out.println(degree);
        }
    }
}
