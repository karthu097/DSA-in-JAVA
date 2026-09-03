class Solution {
    public int largestInteger(int n, int s) {
        // If the sum is greater than the maximum possible sum (all 9s), it's impossible
        if (s > 9 * n) {
            return -1;
        }
        
        int result = 0;
        
        // Greedily place the largest possible digit from left to right
        for (int i = 0; i < n; i++) {
            int digit = Math.min(9, s);
            result = result * 10 + digit;
            s -= digit;
        }
        
        return result;
    }
}