import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int count = 1;
        // 최단거리니까 BFS
        // 사각형 내부 공간에 접근 불가(변이어도 다른 사각형 내부라면 불가하니까)
        
        // rectangle[][0]: 좌하x, rectangle[][1]: 좌하y, rectangle[][2]: 우상x, rectangle[][3]: 우상y
        // 1. 어떤 사각형이든지 테두리에 존재해야하며
        // (rectangle[][0] <= x <= rectangle[][2]) && (rectangle[][1] <= y <= rectangle[][3])
        // 2. 어떤 사각형이든지 그 내부에 있어서는 안됨
        
        final int SIZE = 101; // 좌표 사이즈(0~100)
        
        int[]dx = {1,-1,0,0};
        int[]dy = {0,0,1,-1};
        
        Queue<int[]>q = new ArrayDeque<>(); // 방문할 좌표 넣을 큐, ArrayDeque는 LinkedList 보다 빠르지만 null은 넣을 수 없음
        boolean[][]visited = new boolean[SIZE][SIZE]; // 좌표 방문 여부 배열
        
        q.offer(new int[]{characterX *2, characterY*2}); // 시작 좌표 큐에 넣기
        visited[characterX*2][characterY*2] = true; // 시작 지점 방문 처리
        
        Set<int[]>line = new HashSet<>(); // 미리 직사각형 테두리 좌표 다 배열로 넣어놓기
        
        Set<int[]>inner = new HashSet<>(); // 미리 직사각형 내부 좌표 다 배열로 넣어놓기
        
        // 테두리, 내부 좌표 넣기
        for(int i=0; i<rectangle.length; i++){
            for(int j=rectangle[i][0]*2; j<=rectangle[i][2]*2; j++){ // x 변
                line.add(new int[]{j, rectangle[i][1]*2});
                line.add(new int[]{j, rectangle[i][3]*2});
                if(j!=rectangle[i][0]*2 && j!= rectangle[i][2]*2){ // 꼭짓점이 아닐때 = 내부 좌표
                    for(int k=rectangle[i][1]*2+1; k<rectangle[i][3]*2; k++){
                        inner.add(new int[]{j, k});
                    }
                }
            }
            for(int j=rectangle[i][1]*2; j<=rectangle[i][3]*2; j++){ // y 변
                line.add(new int[]{rectangle[i][0]*2, j});
                line.add(new int[]{rectangle[i][2]*2, j});
            }
        }
        while(!q.isEmpty()){
            
            int size = q.size();
            for(int i=0; i<size; i++){
                int[]temp = q.poll();
                
                for(int j=0; j<4; j++){
                    int nx = temp[0] + dx[j];
                    int ny = temp[1] + dy[j];
                    // 도착하면 나가기
                    if(nx == itemX*2 && ny == itemY*2){
                        return count/2;
                    }
                    boolean isLine = false; // 테두리 여부
                    boolean isIn = false; // 내부 여부
                    for(int[]l : line){
                        if(nx == l[0] && ny == l[1])
                            isLine = true;
                    }
                    for(int[]in : inner){
                        if(nx == in[0] && ny == in[1])
                            isIn = true;
                    }
                    if(nx>=1 && nx<=100 && ny >=1 && ny<=100 && !visited[nx][ny] && isLine && !isIn){ // 테두리고 내부 아닐때만
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            count++;
        }
        return 0;
    }
}