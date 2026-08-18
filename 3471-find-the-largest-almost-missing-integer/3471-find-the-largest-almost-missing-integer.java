import java.util.HashMap;
import java.util.Map;

class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        
        // Case 1: k == 1 -> Largest element that appears exactly once in nums
        if (k == 1) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int num : nums) {
                count.put(num, count.getOrDefault(num, 0) + 1);
            }
            int ans = -1;
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                if (entry.getValue() == 1) {
                    ans = Math.max(ans, entry.getKey());
                }
            }
            return ans;
        }
        
        // Case 2: k == n -> Largest element in nums
        if (k == n) {
            int maxVal = -1;
            for (int num : nums) {
                maxVal = Math.max(maxVal, num);
            }
            return maxVal;
        }
        
        // Case 3: 1 < k < n -> Only nums[0] or nums[n - 1] can appear in 1 subarray
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        int ans = -1;
        if (count.get(nums[0]) == 1) {
            ans = Math.max(ans, nums[0]);
        }
        if (count.get(nums[n - 1]) == 1) {
            ans = Math.max(ans, nums[n - 1]);
        }
        
        return ans;
    }
}