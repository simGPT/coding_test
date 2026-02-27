import java.util.Scanner;


public class Main {
	public static void main(String[]args) {
		
		String s;
		int count[] = new int[26];
		Scanner scan = new Scanner(System.in);
		int maxCount = 0;
		char maxValue = 0;
		
		s = scan.next().toUpperCase(); 
		char[]c = s.toCharArray(); 
		for(int i=0; i<c.length; i++) {
			count[c[i]-'A']++;
			
			if(maxCount < count[c[i]-'A']) {
				maxCount = count[c[i]-'A'];
				maxValue = c[i];
			}
			else if(maxCount == count[c[i]-'A']) {
				maxValue = '?';
			}
		}
		
		System.out.println(maxValue);
	}
}
