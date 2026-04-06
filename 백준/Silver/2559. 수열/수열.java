import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {


        // 백준 2559번 -> 슬라이딩 윈도우 문제
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int []grid = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            grid[i] = Integer.parseInt(st.nextToken());
        }

        int windowSum = 0;
        for(int i=0; i<K; i++){
            windowSum += grid[i];
        }
        int maxSum = windowSum;

        for(int i=0; i<grid.length-K; i++){
            windowSum = windowSum - grid[i] + grid[i+K];
            maxSum = Math.max(maxSum, windowSum);
        }
        System.out.println(maxSum);

    }
}
