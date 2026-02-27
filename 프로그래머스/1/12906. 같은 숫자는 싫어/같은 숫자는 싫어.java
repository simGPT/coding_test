import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int temp = 10;
        Queue<Integer>q = new ArrayDeque<>();
        for(int n : arr){
            if(temp==n)
                continue;
            else{
                temp=n;
                q.offer(temp);
            }
        }
        int[]answer = new int[q.size()];
        int i = 0;
        while(!q.isEmpty()){
            answer[i++] = q.poll();
        }
        return answer;
    }
}