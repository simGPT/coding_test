import java.util.*;

class Solution{
    public int [] solution(int[]progresses, int[]speeds){
        List <Integer> result = new ArrayList<>(); // 결과 배열
        int prevDay = 0; // 같은 번째 배포 묶음에서의 가장 배포 기준 날짜 수 ex)7,3,5 -> 7
        int count = 0;
        for(int i=0; i<progresses.length; i++){
            double temp = 100-progresses[i];
            int day = (int)Math.ceil(temp/speeds[i]); // 현재 계산한 남은 날짜
            
            if(day>prevDay){ // 이게 첫 배포 묶음일때 ex) 7,3,9 -> 9일때
                if(count>0) // 이전까지의 배포 묶음을 배열에 넣기 ex) 7,3 -> count=2
                    result.add(count);
                count = 1; // 다시 count 시작
                prevDay = day; // 현재 배포 묶음에서의 배포 기준 날짜 수 갱신 ex) 7,3,9 -> 9로 갱신
            }else{ // 첫 배포 묶음이 아닐때
                count++;
            }
        }
        // 반복문이 끝나면 다시 한번 마지막 count를 넣어줘야 함
        result.add(count);
        
        return result.stream().mapToInt(i->i).toArray();
    }
}