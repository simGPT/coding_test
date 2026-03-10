import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0; // 섞는 횟수
        PriorityQueue<Integer>q = new PriorityQueue<>();
        for(int s:scoville){
            q.offer(s); // 우선순위 큐에 다 scoville 배열 삽입
        }
        int sum = 0; // 섞은 음식의 스코빌 지수
        while(q.size()>1 && q.peek()<K){ // 스코빌 지수가 K 보다 커지거나 q가 빈 큐가 되면 섞기 종료
            int first = q.poll();
            int second = q.poll();
            sum = first + second*2; // 섞은 스코빌 지수
            q.offer(sum); // 다시 우선순위 큐에 삽입
            count++; // 횟수 증가
        }
        if(q.size()<=1 && q.peek()<K) // q가 1개밖에 안남고 여전히 sum이 K 보다 작다면
            count = -1;
        return count;
    }
}