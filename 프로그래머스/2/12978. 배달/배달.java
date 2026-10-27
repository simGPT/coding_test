import java.util.*;

class Solution {
    
    static final int INF = Integer.MAX_VALUE; 
    
    public int solution(int N, int[][] road, int K) { // N: 마을 수, K 이하여야 배달 가능
        // 1번이 시작점, 1번으로부터 거리가 K이하인 마을 수 구하기
        // 모든 마을에 대한 최단거리를 구하고 그중 거리가 K 이하인 것 구하면 됨
        int count = 0;
        
        // 그래프 저장
        List<List<int[]>>graph = new ArrayList<>();
        for(int i=0; i<N+1; i++){
            graph.add(new ArrayList<>());
        }
        for(int[]r : road){
            graph.get(r[0]).add(new int[]{r[1], r[2]});
            graph.get(r[1]).add(new int[]{r[0], r[2]});
        }
        
        int[]dist = new int[N+1]; // 노드 1부터 시작
        Arrays.fill(dist,INF);
        dist[1] = 0; // 시작지점 거리는 0
        dist[0] = K+1;
        
        Queue<int[]>pq = new PriorityQueue<>((a,b)->a[1]-b[1]); // 가중치 오름차순으로 넣기
        pq.offer(new int[]{1,0}); // 시작지점 큐에 넣기
            
        while(!pq.isEmpty()){
            int[]cur = pq.poll();
            int city = cur[0], cost = cur[1];
            
            for(int[]next : graph.get(city)){
                int nextCity = next[0];
                int nextDist = cost + next[1];
                if(nextDist < dist[nextCity]){
                    dist[nextCity] = nextDist;
                    pq.offer(new int[]{nextCity, nextDist});
                }
            }
        }
        
        for(int i : dist){
            if(i<=K)
                count++;
        }
        return count;
    }
}