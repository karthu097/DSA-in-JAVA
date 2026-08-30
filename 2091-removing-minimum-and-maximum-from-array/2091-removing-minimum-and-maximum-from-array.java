class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;

        int minIndex = 0;
        int maxIndex = 0;

        // Find the indices of the minimum and maximum elements
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        int min = Math.min(minIndex, maxIndex);
        int max = Math.max(minIndex, maxIndex);

        // Scenario 1: Remove both from the front
        int deleteFront = max + 1;
        
        // Scenario 2: Remove both from the back
        int deleteBack = n - min;
        
        // Scenario 3: Remove one from the front and one from the back
        int deleteBoth = (min + 1) + (n - max);

        // Return the minimum of the three scenarios
        return Math.min(deleteFront, Math.min(deleteBack, deleteBoth));
    }
}