class Solution {
    public int numberOfSets(int n, int k) {
        long MOD = 1_000_000_007;
        int totalObjects = n + k - 1;
        int r = 2 * k;
        
        // Compute C(totalObjects, r) % MOD
        long[] inv = new long[r + 1];
        inv[1] = 1;
        for (int i = 2; i <= r; i++) {
            inv[i] = (MOD - MOD / i) * inv[(int)(MOD % i)] % MOD;
        }
        
        long res = 1;
        for (int i = 0; i < r; i++) {
            res = (res * (totalObjects - i)) % MOD;
            res = (res * inv[i + 1]) % MOD;
        }
        
        return (int) res;
    }
}