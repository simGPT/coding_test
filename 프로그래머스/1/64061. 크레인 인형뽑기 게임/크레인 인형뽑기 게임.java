import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Deque<Integer>>list = new ArrayList<>(); // 덱 리스트
        Deque<Integer>deque = new ArrayDeque<>(); // 옮겨서 담을 덱
        // 덱 초기화
        for(int i=0; i<board.length; i++){
            list.add(new ArrayDeque<>());
        }
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] != 0){
                    list.get(j).offerFirst(board[i][j]); // 값 넣어주기
                }
            }
        }
        for(int n:moves){
            if(list.get(n-1).isEmpty())
                 continue;
            int temp = list.get(n-1).pollLast(); // 꺼내기
            if(!deque.isEmpty()&&deque.peekLast()==temp){ // 앞에 있는 인형과 같을때
                deque.pollLast();
                answer+=2;
            }else{
                deque.offerLast(temp); // 넣기
            }
        }
        return answer;
    }
}