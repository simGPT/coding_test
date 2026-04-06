
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException { // StringTokenizer 는 예외처리 필요
//        Scanner scan = new Scanner(System.in);
//        int a = scan.nextInt();
//        int b = scan.nextInt();
//        System.out.println(a+b);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼를 통한 입력 -> 좀 더 빠름
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()); // 스페이스 바를 기준으로 나누는 것
        int b = Integer.parseInt(st.nextToken());
        System.out.println(a+b);

    }
}