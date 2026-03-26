import java.util.*;

class Solution {
    boolean solution(String s) {
        int count = 0;
        for(char c:s.toCharArray()){
            if(c=='(')
                count++;
            else
                count--;
            if(count<0) // 닫는 괄호가 앞에 더 많이 나오면 안됨 -> 여는 괄호 후에 닫는 괄호가 무조건 나와야 함
                return false;
        }
        if(count==0)
            return true;
        return false;
            
    }
}