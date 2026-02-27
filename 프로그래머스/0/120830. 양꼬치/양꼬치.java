class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int m = 0;
        int j = n/10;
        if(k<j){
            m = 0;
        }else{
            m = k-j;
        }
        answer = 12000*n + 2000*m;
        return answer;
    }
}