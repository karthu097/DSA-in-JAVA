import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] indexedNums = new int[n][2];
        for (int i = 0; i < n; i++) {
            indexedNums[i][0] = nums[i];
            indexedNums[i][1] = i;
        }

        // Sort by value
        Arrays.sort(indexedNums, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[n];
        List<Integer> currentGroupValues = new ArrayList<>();
        List<Integer> currentGroupIndices = new ArrayList<>();

        currentGroupValues.add(indexedNums[0][0]);
        currentGroupIndices.add(indexedNums[0][1]);

        for (int i = 1; i < n; i++) {
            if (indexedNums[i][0] - indexedNums[i - 1][0] <= limit) {
                currentGroupValues.add(indexedNums[i][0]);
                currentGroupIndices.add(indexedNums[i][1]);
            } else {
                Collections.sort(currentGroupIndices);
                for (int j = 0; j < currentGroupIndices.size(); j++) {
                    result[currentGroupIndices.get(j)] = currentGroupValues.get(j);
                }
                currentGroupValues.clear();
                currentGroupIndices.clear();
                currentGroupValues.add(indexedNums[i][0]);
                currentGroupIndices.add(indexedNums[i][1]);
            }
        }

        // Process the last group
        Collections.sort(currentGroupIndices);
        for (int j = 0; j < currentGroupIndices.size(); j++) {
            result[currentGroupIndices.get(j)] = currentGroupValues.get(j);
        }

        return result;
    }
}