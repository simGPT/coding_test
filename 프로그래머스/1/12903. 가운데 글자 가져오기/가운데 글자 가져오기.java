import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        char[]c = s.toCharArray();
        char[]a = new char[2];
        if(c.length % 2 == 0){
            a[0]=c[c.length/2-1];
            a[1]=c[c.length/2];
            answer = new String(a);
        }else if(c.length == 1)
            answer = String.valueOf(c[0]);
        else{
            answer = String.valueOf(c[(c.length-1)/2]);
        }
        return answer;
    }
}