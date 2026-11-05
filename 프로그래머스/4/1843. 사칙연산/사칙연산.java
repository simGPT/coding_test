import java.util.*;

class Solution {
    public int solution(String arr[]) { // 인덱스 짝수면 숫자, 홀수면 기호
        int answer = -1;
        
        List<Integer>nums = new ArrayList<>(); // 숫자 리스트
        List<String>pm = new ArrayList<>(); // 연산자 리스트
        
        for(int i=0; i<arr.length; i++){
            if(i%2==0){ // 짝수, 숫자
                int num = Integer.parseInt(arr[i]);
                nums.add(num);
            }else{ // 홀수, 연산자
                pm.add(arr[i]);
            }
        }
        
        int n = nums.size();
        
        int[][]max = new int [n][n];
        int[][]min = new int [n][n];
        
        // 초기화
        for(int i=0; i<n; i++){ // 숫자 배열 원소 개수만큼 반복문
            for(int j=0; j<n; j++){
                max[i][j] = Integer.MIN_VALUE;
                min[i][j] = Integer.MAX_VALUE;
            }
            min[i][i] = nums.get(i);
            max[i][i] = nums.get(i);
        }
        
        // 괄호로 묶여질 수 있는 구간 길이
        for(int len=1; len<n; len++){
            for(int i=0; i+len<n; i++){ // i : 구간 시작 번호, j : 구간 끝 번호
                int j = i+len;
                
                for(int k=i; k<j; k++){ // 구간의 시작부터 끝까지의 최대, 최소를 구한다
                    if(pm.get(k).equals("+")){
                        max[i][j] = Math.max(max[i][j],max[i][k]+max[k+1][j]);
                        min[i][j] = Math.min(min[i][j],min[i][k]+min[k+1][j]);
                    }else{
                        max[i][j] = Math.max(max[i][j],max[i][k]-min[k+1][j]);
                        min[i][j] = Math.min(min[i][j],min[i][k]-max[k+1][j]);
                    }
                }
            }
        }
        answer = max[0][n-1];
        
        return answer;
    }
}