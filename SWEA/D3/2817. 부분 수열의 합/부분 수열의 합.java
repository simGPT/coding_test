/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution{
	static int count, n, k;
	static int[]a;
	
	static void dfs(int index, int sum) {
		
		if(index == n) {
			if(sum==k)
				count++;
			return;
		}
		dfs(index+1, sum+a[index]); // 해당 인덱스를 선택하는 경우 
		dfs(index+1, sum); // 해당 인덱스를 선택하지 않는 경우 
	}
	
	public static void main(String args[]) throws Exception
	{
		
		//System.setIn(new FileInputStream("res/sample_input.txt"));

		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		// n개의 자연수 수열 a(1~100) , 부분 수열의 합이 k가 되는 경우의 수 출력 
		for(int test_case = 1; test_case <= T; test_case++){
			 
			count = 0; // 경우의 수 
			n = sc.nextInt();
			k = sc.nextInt();
			a = new int [n];
			for(int i=0; i<n; i++) {
				a[i] = sc.nextInt();
			}
			
			dfs(0,0);
			System.out.println("#"+test_case+ " "+ count);
		}
		
		
	}
}