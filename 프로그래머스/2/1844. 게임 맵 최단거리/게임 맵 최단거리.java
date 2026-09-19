import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        int rows = maps.length; // 행의 개수
        int cols = maps[0].length; // 열의 개수
        
        int[]dx = {1, -1, 0, 0};
        int[]dy = {0, 0, 1, -1};
        
        Queue<int[]> q = new LinkedList<>(); // 각 단계에서 탐색할 좌표 저장해놓는 역할
        
        boolean[][]visited = new boolean[rows][cols]; // 방문 여부 저장 배열
        
        q.offer(new int[]{0,0}); // 시작 좌표 미리 삽입
        visited[0][0] = true; // 시작 지점 방문 처리
        int count = 1; // 시작 지점도 칸 수로 카운팅 
        
        while(!q.isEmpty()){
            
            int size = q.size(); // 현재 위치에서 탐색해야하는 좌표 개수
            
            // 탐색할 좌표 하나씩 꺼내서 탐색
            for(int s=0; s<size; s++){
                int[]temp = q.poll();
                int x = temp[0];
                int y = temp[1];
                // visited[x][y] = true;
                
                // 목표 위치 도달 시 바로 최단거리이기 때문에 탈출
                if(x==rows-1 && y==cols-1){
                    return count;
                }
             
                // 다음 탐색할 좌표들 큐에 삽입
                for(int i=0; i<4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                        
                    if(nx>=0 && ny>= 0 && nx<rows && ny<cols && !visited[nx][ny] && maps[nx][ny]==1){
                        visited[nx][ny] = true; // 반드시 여기서 즉 큐에 넣을때 방문 처리를 해야함!
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            count++; // 같은 거리의 모든 좌표들 한번씩 다 탐색하고 나면 카운팅
        }    
       return -1;
    }
}