class Solution {
    public int solution(int[][] sizes) {
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0]<sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        int max_w=sizes[0][0];
        int max_h=sizes[0][1];
        for(int i=0; i<sizes.length; i++){
            if(max_w<sizes[i][0]) max_w = sizes[i][0];
            if(max_h<sizes[i][1]) max_h = sizes[i][1];
        }
        return max_w * max_h;
    }
}