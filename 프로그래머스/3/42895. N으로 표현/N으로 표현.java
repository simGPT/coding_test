import java.util.*;

class Solution {
    public int solution(int N, int number) { 
        // N을 이용해서 number를 만들때 N 이용 최소 횟수 return
        
        int answer = -1;
        
        String temp = String.valueOf(N);
        int[]num = new int[8]; // 숫자 배열
        List<Set<Integer>>dp = new ArrayList<>();
        dp.add(new HashSet<>()); // dp[0]은 안쓰니까 그냥 구현만
        
        // 각 HashSet에는 숫자 개수에 따라 나올 수 있는 모든 값 저장
        
        // 숫자 배열에 채우기
        for(int i=0; i<8; i++){
            num[i] = Integer.parseInt(temp);
            temp += String.valueOf(N);
        }
        
        for(int i=1; i<=8; i++){
            Set<Integer>set = new HashSet<>();
            if(i==1){
                set.add(num[0]);
                dp.add(set);
                if(set.contains(number))
                    return i;
                continue;
            }
            // dp[5]는 dp[1],dp[4]/dp[2],dp[3]/dp[3],dp[2]/dp[4],dp[1] 의 조합임
            for(int k=1; k<=i-1; k++){
                for(int a:dp.get(k)){
                    for(int b:dp.get(i-k)){
                        set.add(num[i-1]);
                        set.add(a+b);
                        set.add(a-b);
                        set.add(a*b);
                        if(b!=0)
                            set.add(a/b);
                    }
                }
            }
            dp.add(set);
            
            if(set.contains(number))
                return i;
        }
        return answer;
    }
}