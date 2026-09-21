class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        // dp[r] keeps track of the number of subarrays ending at the previous index with product % k == r
        long[] dp = new long[k];
        
        for (int num : nums) {
            long[] nextDp = new long[k];
            int rem = num % k;
            
            // A new subarray starting and ending at the current element
            nextDp[rem]++;
            
            // Extend all previous subarrays ending at the previous index
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int newRem = (r * rem) % k;
                    nextDp[newRem] += dp[r];
                }
            }
            
            dp = nextDp;
            
            // Accumulate counts into the final
            for (int r = 0; r < k; r++) {
                result[r] += dp[r];
            }
        }
        
        return result;
    }
}