import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        List<Integer>list = new ArrayList<>();
        for(int i=0; i<rank.length; i++){
            if(attendance[i]){ // 출석일때
                list.add(i);
            }
        }
        list.sort((a,b)-> rank[a]-rank[b]); // 오름차순 정렬
        int a = list.get(0);
        int b = list.get(1);
        int c = list.get(2);
        return 10000*a+100*b+c;
    }
}