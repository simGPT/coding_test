import java.util.*;
class Solution {
    public int solution(String[][] board, int h, int w) {
        int[]dh = {0, 1, -1, 0};
        int[]dw = {1, 0, 0, -1};
        int count = 0;
        String color = board[h][w]; // 현재 위치 색상
        for(int i=0; i<4; i++){
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            if(h_check<0 || h_check >=board.length || w_check<0 || w_check >=board[0].length)
                continue;
            if(board[h_check][w_check].equals(color)){
                count++;
            }   
        }
        return count;
    }
}