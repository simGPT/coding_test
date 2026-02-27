import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer>map = new HashMap<>(); // <이름, 참여자 이름 별 사람 수>
        for(String s : participant)
            map.put(s, map.getOrDefault(s,0)+1); // s가 없으면 0반환 후 1넣기, s가 있으면 원래 있던 값에 1++ 넣기
        for(String s : completion){
            int n = map.get(s);
            if(n==1) // 한 개만 있을때
                map.remove(s);
            else // 여러 개 있을떄
                map.put(s,n-1);
            //(n==0)?map.remove(s):map.put(s,n-1); // 0개 되면 map에서 삭제, 0개 아니면 개수 하나 차감
        }
        return map.keySet().iterator().next(); // map의 key 한 개만 반환
    }
}