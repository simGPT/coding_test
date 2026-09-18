import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 인덱스 location인 원소가 몇번째로 실행되는지
        // priorities가 높을수록 우선순위가 높음
        int answer = 0;
        int size = priorities.length;
        int count = 1;
        
        Deque<int[]>q = new ArrayDeque<>(); // [인덱스, priorities 값]
        int[]result = new int[size]; // 몇 번째로 나오는지 결과 담는 배열
        
        for(int i=0; i<size; i++){ // 덱에 배열 형태로 넣기
            q.offerLast(new int[]{i, priorities[i]});
        }
        
        while(!q.isEmpty()){
            
            int maxIndex = 0; // 배열의 최댓값을 가지는 인덱스
            for(int i=0; i<size; i++){
                if(priorities[i]>priorities[maxIndex])
                    maxIndex = i;
            }
            
            int[]temp = q.pollFirst(); // 맨앞 꺼내기
            
            // 맨 앞에서 꺼낸 덱의 값이 배열의 최댓값과 같다면 
            if(temp[1]==priorities[maxIndex]){
                result[temp[0]] = count; // 몇번째인지 결과 배열에 저장
                count++;
                priorities[maxIndex] = 0; // 이미 가장 나간 원소의 우선순위 값은 0으로 만들기
            }else{
                q.offerLast(temp); // 아니면 다시 덱의 뒤로 넣기
            }
            
        }
        answer = result[location];
        
        return answer;
    }
}