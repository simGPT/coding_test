import java.util.*;

class Solution {
    public int solution(int n, int[][] vertex) { // 간선리스트 형태로 주어짐
        // 인접 리스트로 그래프 구성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] v : vertex) {
            graph.get(v[0]).add(v[1]);
            graph.get(v[1]).add(v[0]);
        }
        
        int[] distance = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        distance[1] = 0;
        
        // 딱 한 번의 BFS로 모든 노드까지의 거리를 한꺼번에 구함
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[cur] + 1;
                    q.offer(next);
                }
            }
        }
        
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, distance[i]);
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == max) {
                answer++;
            }
        }
        
        return answer;
    }
}