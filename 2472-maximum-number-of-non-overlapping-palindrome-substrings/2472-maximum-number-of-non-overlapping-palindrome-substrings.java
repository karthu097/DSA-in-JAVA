import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        List<int[]> intervals = new ArrayList<>();

        // Find all valid palindromes of length >= k
        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;

            // Expand around center
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;
                if (len >= k) {
                    intervals.add(new int[]{left, right});
                }
                left--;
                right++;
            }
        }

        // Sort intervals by their end points (Greedy interval scheduling
        Collections.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int lastEnd = -1;

        for (int[] interval : intervals) {
            if (interval[0] > lastEnd) {
                count++;
                lastEnd = interval[1];
            }
        }

        return count;
    }
}