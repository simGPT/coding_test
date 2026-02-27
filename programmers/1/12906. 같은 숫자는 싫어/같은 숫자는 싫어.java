import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> result = new ArrayDeque<>();
        
        for (int num : arr) {
            if (result.isEmpty() || result.peekLast() != num) {
                result.addLast(num);
            }
        }

        // Deque를 배열로 변환
        int[] answer = new int[result.size()];
        int i = 0;
        for (int num : result) {
            answer[i++] = num;
        }

        return answer;
    }
}
