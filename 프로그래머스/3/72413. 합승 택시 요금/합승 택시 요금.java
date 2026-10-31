import java.util.*;

class Solution {
    
    final int INF = 20000000;
    public int solution(int n, int s, int a, int b, int[][] fares) { // n 지점 개수(1~n), s는 시작 노드
        
        int answer = INF;
        
        // Sol1) 귀가하는데 예상되는 최저 금액 (같이 타고간 만큼 가격을 뺄까?) -> 틀림
        // Sol2) 노드 수가 200개 이하, 중간 지점 k를 설정하고 {(s->k) + (k->a) + (k->b)} 의 최솟값을 구하면 됨.
        
        // 1. 추후 모든 노드간의 최소 거리를 저장할 행렬 생성
        int[][]dist = new int[n+1][n+1]; // 각 노드간 가중치를 배열에 저장
        
        // 2. 추후 채워질 행렬이라서 미리 초기화 시켜줘야함
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                dist[i][j] = (i==j) ? 0 : INF; // 자기자신까지의 거리는 0으로
            }
        }
        
        // 3. 일단은 각 노드 간 가중치를 문제에서 주어진 대로 채우기 -> 추후 임의의 k 지점을 거쳐서라도 더 최단거리가 있다면 해당 값으로 갱신 예정
        for(int[]f : fares){ // fares 갯수는 간선의 수라서 예측이 불가하니까 반드시 for-each 문으로
            dist[f[0]][f[1]] = f[2];
            dist[f[1]][f[0]] = f[2];
        }
        
        // 4. 주어진 각 노드 간 가중치보다 k지점을 거치는게 더 최단거리라면 행렬 값을 갱신.
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(dist[i][j]>dist[i][k]+dist[k][j])
                        dist[i][j] = dist[i][k]+dist[k][j];
                }
            }
        }
        
        // 5. 최솟값 구하기
        for(int k=1; k<=n; k++){
            int temp = dist[s][k]+dist[k][a]+dist[k][b];
            if(answer > temp)
                answer = temp; // 최솟값으로 갱신
        }
        return answer;
    }
}