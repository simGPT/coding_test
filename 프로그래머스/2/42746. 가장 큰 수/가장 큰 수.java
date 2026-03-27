import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer ="";
        String[]str = new String[numbers.length]; // 빈 문자열 배열
        for(int i=0; i<numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, (a,b) -> (b+a).compareTo(a+b)); // (b+a)가 더 큰거면 양수 반환 -> b+a가 앞으로 와야함
        answer = String.join("",str);
        if(answer.startsWith("0"))
            answer = "0";
        return answer;
    }
}