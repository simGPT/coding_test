import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) { 
        // 장르의 재생 수 > 노래의 재생 수 > 고유번호 낮은 순
        // 장르 당 두 곡씩 들어감, 고유번호 순서대로 return
        List<Integer>result = new ArrayList<>();
        
        Map<String, List<Integer>>map = new HashMap<>(); // 장르, 인덱스
        Map<String,Integer>playsMap = new HashMap<>(); // 장르, 장르별 총 재생수
        
        // 장르만 들어있는 set(중복 X)
        Set<String>set = new HashSet<>();
        for(int i=0; i<genres.length; i++){
            set.add(genres[i]);
        }
        
        for(String s:set){
            List<Integer>list = new ArrayList<>();
            int sum = 0;
            
            for(int i=0; i<genres.length; i++){
                if(s.equals(genres[i])){
                    list.add(i);
                }
            }
            map.put(s,list); // 장르별 인덱스 저장 
            for(int l:list)
                sum += plays[l];
            playsMap.put(s,sum); // 장르, 장르별 재생 수 저장
        }
        
        List<String>keys = new ArrayList<>(playsMap.keySet()); // ex) classic, pop
        keys.sort((a, b)->playsMap.get(b)-playsMap.get(a)); // 내림차순 정렬
        
        for(String k:keys){
            List<Integer>temp = new ArrayList<>(map.get(k));
            temp.sort((a, b)->plays[b]-plays[a]); // 내림차순 정렬 [3,0,2]800, 500, 150
            
            if(temp.size() == 1){
                result.add(temp.get(0));
                continue;
            }
                
            if(plays[temp.get(0)] == plays[temp.get(1)]){ // 같을땐 고유번호로
                result.add(Math.min(temp.get(0),temp.get(1)));
                result.add(Math.max(temp.get(0),temp.get(1)));
                continue;
            }
            // 다를땐 그냥 큰것부터 두개 삽입
            result.add(temp.get(0));
            result.add(temp.get(1));
        }
        
        return result;
    }
}