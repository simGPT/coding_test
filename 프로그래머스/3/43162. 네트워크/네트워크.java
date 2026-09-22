import java.util.*;

class Solution {
    
    static boolean[]visited = {}; // 컴퓨터 방문 여부 배열
    static int count = 0; // 네트워크 개수
    
    public int solution(int n, int[][] computers) { // n개면 0~n-1번 까지 존재
        // [[0번째와 연결되어있는 컴퓨터는 1로],[1번째 ..],[2번째 ..]]
        
        // [__, 0과1, 0과2, 0과3], 
        // [1과0, __, 1과2, 1과3], 
        // [2과0, 2과1, __, 2와3],
        // [3과0, 3과1, 3와2, __]
        
        // 혼자 떨어진 것도 네트워크임 
        // DFS로 풀면 될듯
        
        visited = new boolean[n]; // 컴퓨터 방문 여부 확인용 배열
        
        // 컴퓨터 수만큼 돌면서 아직 방문 안한애만 탐색해야함
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(n, i,computers);
                count++;
            }
        }
        return count;
    }
    public void dfs(int n, int c, int[][] computers){
        
        visited[c] = true; // 방문처리
        
        for(int i=0; i<n; i++){
            if(computers[c][i]==1 && visited[i]==false){
                dfs(n, i, computers);
            }
        }
    }
}