class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;

        // 아래에서 위로 올라가면서 최댓값 고르라고 하기
        for(int i = n-2; i >= 0; i--){
            for(int j = 0;  j<=i; j++){
                triangle[i][j] += Math.max(triangle[i+1][j],triangle[i+1][j+1]);
            }
        }
        return triangle[0][0];
    }
}