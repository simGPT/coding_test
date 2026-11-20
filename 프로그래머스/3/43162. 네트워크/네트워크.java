import java.util.*;

class Solution {
    static boolean[]visited = {};
    static int count = 0;
    
    public void dfs(int n, int c, int[][]computers){
        
        visited[c] = true; // 방문처리
        for(int i=0; i<n; i++){
            if(computers[c][i]==1 && !visited[i])
                dfs(n, i, computers);
        }
    }
    
    public int solution(int n, int[][] computers) { 
        
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(n, i, computers);
                count++;
            }
        }
        
        return count;
    }
}