class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        
        // Step 1: Calculate the prefix sum for the entire array
        // This represents pref[n - 1]
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        
        // Step 2: Initialize dp with the base case
        // If we take all stones (i = n - 1), the other player has no moves left
        int dp = sum; 
        
        // Step 3: Iterate backwards from the second-to-last possible choice down to index 1
        // We stop at 1 because the rules state we must remove at least x > 1 stones (index 1 is the 2nd stone)
        for (int i = n - 2; i >= 1; i--) {
            sum -= stones[i + 1]; // This updates our sum to be pref[i]
            dp = Math.max(dp, sum - dp);
        }
        
        return dp;
    }
}