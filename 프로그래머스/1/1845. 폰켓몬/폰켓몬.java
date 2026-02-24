import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int n, r = 0;
        Set <Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        return Math.min(set.size(),nums.length/2);
    }
}