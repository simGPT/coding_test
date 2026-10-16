import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // begin에서 딱 하나만 바꾼게 words에 계속 있어야 함
        // 최단거리 구하는 문제 -> BFS
        
        int count = 0; // 단계 수
        int wordsSize = words.length;
        
        Queue<String>q = new ArrayDeque<>(); // 다음 방문 예정인 단어 배열
        
        boolean[]isVisitedWord = new boolean[wordsSize]; // 단어 방문 여부 저장 배열
        
        q.offer(begin); // 시작 단어 넣기
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0; i<size; i++){
                String temp = q.poll(); // 꺼내기
                if(temp.equals(target)){ // 타겟이 맞으면 멈추기
                    return count;
                }
                for(int j=0; j<wordsSize; j++){
                    
                    int diff = 0; // 다른거 개수
                    for(int k=0; k<temp.length(); k++){
                        if(temp.charAt(k)!=words[j].charAt(k))
                            diff++;
                    }
                    
                    if(!isVisitedWord[j] && diff==1){  // 아직 방문 안했고, 하나만 차이날때 다음 방문 예정
                        q.offer(words[j]); // 다음 방문 예정 큐에 삽입
                        isVisitedWord[j] = true; // 방문 처리
                    }
                } 
            }
            count++; // 단계 추가
        }
        return 0; // 끝까지 도달 못하면 0
    }
}