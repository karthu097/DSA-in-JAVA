class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        int n = s.length();
        
        // dp[i] stores the total number of distinct subsequences ending with the character (i + 'a')
        long[] dp = new long[26];
        long totalSum = 0;
        
        for (int i = 0; i < n; i++) {
            int charIndex = s.charAt(i) - 'a';
            
            // New subsequences ending with current character
            long newSubseq = (totalSum + 1) % MOD;
            
            // Subtract previously counted subsequences that ended with the same character to avoid duplicates
            totalSum = (totalSum - dp[charIndex] + newSubseq + MOD) % MOD;
            
            // Update the count for this characte
            dp[charIndex] = newSubseq;
        }
        
        return (int) totalSum;
    }
}