class Solution {
    int count = 0;
    
    public void dfs(int[] numbers, int target, int depth, int sum){
        if(depth == numbers.length){
            if(sum == target)
                count++;
            return;
        }
        dfs(numbers, target, depth+1, sum+numbers[depth]); // + 인 경우
        dfs(numbers, target, depth+1, sum-numbers[depth]); // - 인 경우
    }
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return count;
    }
}