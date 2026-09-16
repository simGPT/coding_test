import java.util.*;

class Solution {
    public int solution(int[][] jobs) { // 인덱스: 작업 번호 [작업 요청 시점, 작업 소요시간]
        int answer = 0;
        
        Arrays.sort(jobs, (a,b) -> a[0]-b[0]); // 작업 요청 시점이 빠른 순으로 정렬
        
        Queue<int[]>heap = new PriorityQueue<>((a, b)-> a[1]-b[1]); // 작업 소요시간이 빠른 순으로 우선순위를 맞춘다.
        
        int n = jobs.length;
        int index = 0; // 처리한 요청 수
        int currentTime = 0; // 현재 시각
        
        // 대기 힙이 비어있지 않고, 처리해야할 요청이 남아 있을때
        while(index<n || !heap.isEmpty()){
            
            // 현재 시점까지 들어온 요청 모두 힙에 넣기
            while(index<n && jobs[index][0] <= currentTime){
                heap.offer(jobs[index]);
                index++;
            }
            if(!heap.isEmpty()){
                int[]job = heap.poll(); // 하나 꺼내기
                answer += currentTime + job[1] - job[0]; // 요청 반환 시간
                currentTime += job[1];
            }else{
                currentTime = jobs[index][0]; // 대기 큐에 아무것도 없을때
            }
        }
        // 요청 반환 시간 = 작업 시작 시간 + 작업 소요시간 - 작업 요청 시간
        // 대기 큐 : 3. 작업 번호 - , 2. 작업 요청 시각 - , 1. 작업 소요시간 -
        // 각 요청 작업의 반환시간 평균 반환
        return (int)(answer/n);
    }
}