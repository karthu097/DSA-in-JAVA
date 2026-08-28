class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        
        // Count character frequencies
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        // Check if a palindromic permutation is possible
        int oddCount = 0;
        char midChar = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
                midChar = (char) (i + 'a');
            }
        }
        
        if (oddCount > 1) {
            return "";
        }
        
        // Pool of available characters for the first half of the palindrome
        int[] pool = new int[26];
        for (int i = 0; i < 26; i++) {
            pool[i] = freq[i] / 2;
        }
        
        int halfN = n / 2;
        String targetHalf = target.substring(0, halfN);
        
        // Find how much of the target's first half we can match exactly
        int L = 0;
        int[] tempPool = pool.clone();
        for (int i = 0; i < halfN; i++) {
            int c = targetHalf.charAt(i) - 'a';
            if (tempPool[c] > 0) {
                tempPool[c]--;
                L++;
            } else {
                break;
            }
        }
        
        // Try the exact match of target's first half if possible
        if (L == halfN) {
            StringBuilder sb = new StringBuilder();
            sb.append(targetHalf);
            if (n % 2 != 0) {
                sb.append(midChar);
            }
            sb.append(new StringBuilder(targetHalf).reverse());
            
            String sPrime = sb.toString();
            if (sPrime.compareTo(target) > 0) {
                return sPrime;
            }
        }
        
        // Backtrack to find the rightmost divergence point where we can place a strictly greater character
        for (int i = Math.min(L, halfN - 1); i >= 0; i--) {
            int[] currentPool = pool.clone();
            
            // Rebuild the available pool for the matched prefix
            for (int j = 0; j < i; j++) {
                currentPool[targetHalf.charAt(j) - 'a']--;
            }
            
            // Find the smallest available character strictly greater than the target's character at index i
            int targetChar = targetHalf.charAt(i) - 'a';
            int nextChar = -1;
            for (int c = targetChar + 1; c < 26; c++) {
                if (currentPool[c] > 0) {
                    nextChar = c;
                    break;
                }
            }
            
            // If a valid divergence is found, construct the lexicographically smallest palindrome
            if (nextChar != -1) {
                StringBuilder half = new StringBuilder();
                half.append(targetHalf.substring(0, i));
                half.append((char) (nextChar + 'a'));
                currentPool[nextChar]--;
                
                // Append remaining characters in sorted (lexicographically smallest) order
                for (int c = 0; c < 26; c++) {
                    while (currentPool[c] > 0) {
                        half.append((char) (c + 'a'));
                        currentPool[c]--;
                    }
                }
                
                StringBuilder full = new StringBuilder();
                full.append(half);
                if (n % 2 != 0) {
                    full.append(midChar);
                }
                full.append(new StringBuilder(half).reverse());
                
                return full.toString();
            }
        }
        
        // No such permutation exists
        return "";
    }
}