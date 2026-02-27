class Solution {
    public int solution(int a, int b) {
        int result1, result2 = 0;
        String str1 = String.valueOf(a);
        String str2 = String.valueOf(b);
        result1 = Integer.parseInt(str1 + str2);
        result2 = 2*a*b;
        
        return result1>result2?result1:result2;
    }
}