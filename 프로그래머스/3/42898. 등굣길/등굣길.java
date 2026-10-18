import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[n + 1][m + 1]; // dp[행][열], 1부터 사용

        // 웅덩이 표시 (puddles는 [열, 행] 순서)
        boolean[][] isPuddle = new boolean[n + 1][m + 1];
        for (int[] p : puddles) {
            isPuddle[p[1]][p[0]] = true;
        }

        dp[1][1] = 1; // 시작점

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (y == 1 && x == 1) continue;
                if (isPuddle[y][x]) {
                    dp[y][x] = 0; // 웅덩이는 지나갈 수 없음
                    continue;
                }
                dp[y][x] = (dp[y - 1][x] + dp[y][x - 1]) % MOD;
            }
        }
        return dp[n][m]; 
    }
}