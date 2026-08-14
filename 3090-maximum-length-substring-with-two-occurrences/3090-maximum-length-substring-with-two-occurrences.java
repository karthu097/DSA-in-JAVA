class Solution {
    public int maximumLengthSubstring(String s) {
        int[] counts = new int[26];
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            counts[curr - 'a']++;

            // Shrink window until the current character count is <= 2
            while (counts[curr - 'a'] > 2) {
                counts[s.charAt(left) - 'a']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}