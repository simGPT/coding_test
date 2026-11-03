import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        Queue<Integer>minHeap = new PriorityQueue<>((a,b)->Integer.compare(a,b)); // 최소 힙
        Queue<Integer>maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b,a)); // 최대 힙
        
        for(int i=0; i<operations.length; i++){
            
            // 1. 삽입할때는 리스트, 최소힙, 최대힙 모두 삽입
            if(operations[i].startsWith("I")){
                int n = Integer.parseInt(operations[i].substring(2));
                minHeap.offer(n);
                maxHeap.offer(n);
            }
            if(minHeap.isEmpty()) continue;
            
            // 2. 최소 힙으로 제거할때
            if(operations[i].equals("D -1")){
                int n = minHeap.poll(); // 최소 힙으로 제거
                maxHeap.remove(n); // 최대 힙에서도 제거 -> 우선순위 큐도 remove로 원하는 값의 원소 제거 가능
            }
            // 3. 최대 힙으로 제거할때
            if(operations[i].equals("D 1")){
                int n = maxHeap.poll(); // 최대 힙으로 제거
                minHeap.remove(n); // 최소 힙에서도 제거
            }
        }
        
        // 최종 리스트가 비어있지 않다면 [최댓값, 최솟값] 반환
        if(!minHeap.isEmpty()){
            int max = maxHeap.poll();
            int min = minHeap.poll();
            answer = new int[]{max, min};
        }else{
            answer = new int[]{0,0};
        }
        
        return answer;
    }
}