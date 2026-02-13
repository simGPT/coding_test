class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        String temp = "";
        int n = my_string.length(); // 주어진 문자열의 접미사 수
        for(int i = 0; i< n; i++ ){
            temp = my_string.substring(i,n);
            if(is_suffix.equals(temp))
                answer = 1;
        }
        return answer;
    }
}