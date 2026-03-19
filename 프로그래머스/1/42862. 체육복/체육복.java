class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer=0;
        int [] arr = new int [n]; // 시뮬레이션 용 배열
        for(int i=0; i<n; i++) arr[i] = 1;
        for(int r : reserve) arr[r-1]++; // 여벌
        for(int l : lost) arr[l-1]--; // 도난
        
        for(int i=0; i<n; i++){
            if(arr[i]==0){
                if(i > 0 && arr[i-1] == 2){
                    arr[i]++;
                    arr[i-1]--;
                }
                else if(i < n-1 && arr[i+1] == 2){
                    arr[i]++;
                    arr[i+1]--;
                }
            }  
        }
        for(int a:arr){
            if(a!=0){
                answer++;
            }
        }
        return answer;
    }
}