import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        Set <Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        return Math.min(set.size(),nums.length/2);
    }
}