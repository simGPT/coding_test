import java.util.*;

class Solution{
    public int [] solution(int[]progresses, int[]speeds){
        
        Deque<Integer>progressesQ = new ArrayDeque<>();
        Deque<Integer>speedsQ = new ArrayDeque<>();
        
        for(int i=0; i<progresses.length; i++){
            progressesQ.offer(progresses[i]);
            speedsQ.offer(speeds[i]);
        }
        
        List<Integer>result = new ArrayList<>(); // 결과 담을 배열
        
        while(!progressesQ.isEmpty()){
            int size = progressesQ.size();
            for(int i=0; i<size; i++){
                int p = progressesQ.poll();
                int s = speedsQ.poll();
                progressesQ.offer(p+s);
                speedsQ.offer(s);
            }
            int count = 0;
            while(!progressesQ.isEmpty()&& progressesQ.peekFirst()>=100){
                progressesQ.poll();
                speedsQ.poll();
                count++;
            }
            if(count > 0)
                result.add(count);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}