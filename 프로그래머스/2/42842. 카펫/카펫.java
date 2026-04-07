import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int[]answer = new int[2];
        int a=0, b=0;
        Deque<Integer>deque = new ArrayDeque<>();
        for(int i=1; i<=sum; i++){ // 완전 탐색으로 약수 찾기
            if(sum%i==0){
                deque.offer(i); // list에는 약수들만
            }
        }
        while(deque.size()>0){
            if(deque.size() == 1){ // 한개인 경우
                a = deque.poll();
                b = a;
                if(a*2+b*2-4 == brown){
                    answer[0] = b;
                    answer[1] = a;
                    break;
                }
            }else{
                a = deque.poll(); // 앞에서 
                b = deque.pollLast(); // 뒤에서
            
                if(a*2+b*2-4 == brown){
                    answer[0] = b;
                    answer[1] = a;
                    break;
                }
            }
        }
        return answer;  
    }
}