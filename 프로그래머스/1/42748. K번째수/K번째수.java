import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int []result = new int [commands.length]; // 결과 배열
        for(int i=0; i<commands.length; i++){
            List<Integer>list = new ArrayList<>(); // 필요한 값만 넣을 배열
            for(int j=commands[i][0]-1; j<=commands[i][1]-1; j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            result[i] = list.get(commands[i][2]-1);
        }
        return result;
    }
}