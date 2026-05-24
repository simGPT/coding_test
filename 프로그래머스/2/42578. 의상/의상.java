import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Set<String>set = new HashSet<>();
        for(String[]str:clothes){
            set.add(str[1]); // 중복없이 추가함
        }
        List<Integer>list = new ArrayList<>(); 
        for(String s:set){
            int n=0;
            for(int i=0; i<clothes.length; i++){
                if(clothes[i][1].equals(s))
                    n++;
            }
            list.add(n);
        }
        for(Integer n:list){
            answer *= (n+1);
        }
        return answer-1;
    }
}