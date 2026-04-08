import java.util.*;

class Solution {
    String [] maps;
    int[]dx = {1, -1, 0, 0};
    int[]dy = {0, 0, 1, -1};
    boolean visited[][];
    int rows, cols;
    
    public int[] solution(String[] maps) {
        
        this.maps = maps;
        rows = maps.length;
        cols = maps[0].length();
        visited = new boolean[rows][cols];
        List<Integer>result = new ArrayList<>();
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(maps[i].charAt(j) != 'X' && !visited[i][j]){
                    result.add(dfs(i,j));
                }
            }
        }
        if(result.isEmpty())
            return new int[]{-1}; // -1 리턴 하도록
        Collections.sort(result);
        
        int[]answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    int dfs(int x, int y){
        visited[x][y] = true;
        int sum = maps[x].charAt(y) - '0'; 
        
        for(int d=0; d<4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(nx<0 || nx>=rows || ny<0 || ny>=cols)
                continue;
            if(visited[nx][ny] || maps[nx].charAt(ny) == 'X')
                continue;
            sum += dfs(nx, ny);
        }
        return sum;
    }
}