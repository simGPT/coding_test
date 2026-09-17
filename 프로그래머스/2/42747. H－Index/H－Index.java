import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // 3번 이상 인용된 논문, 3편 이상, 나머지는 3번 이하 인용(3번이 가장 많이 인용된 것)
        
        int answer = 0;
        int n = citations.length;
        
        Arrays.sort(citations); // 오름차순 정렬
        
        for(int h=citations[n-1]; h>=0; h--){ // 가장 많이 인용된 횟수 만큼
            int overCount = 0; // h번 이상 인용된 논문 수
            
            for(int i=0; i<n; i++){
                if(citations[i]>=h)
                    overCount++;
            }
            if(overCount>=h){
                answer = h;
                return answer;
            }
        }
        return answer;
    }
}