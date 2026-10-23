class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        boolean[][] win = new boolean[n+1][n+1];
        
        for(int[]r:results){
            win[r[0]][r[1]] = true; // 이긴 것만 true로 행렬 초기화
        }
        
        // 플로이드-워셜로 인접행렬에서 이긴 부분을 다 채우기
        for(int k=1; k<=n; k++){ // 중간 지점 노드
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(win[i][k] && win[k][j])
                        win[i][j] = true;
                }
            }
        }
        // 순위가 확정되었다는 것 = 나를 제외한 모든 노드와 나와의 관계가 있어야 함(이기거나 지거나)
        for(int i=1; i<=n; i++){
            int count =0;
            for(int j=1; j<=n; j++){
                if(win[i][j] || win[j][i])
                    count++;
            }
            if(count == n-1)
                answer++;
        }
        return answer;
    }
}