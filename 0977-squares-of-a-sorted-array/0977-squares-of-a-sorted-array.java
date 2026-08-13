class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int[] result = new int[n];

        // Fill result array from right to left (largest to smallest)
        for (int pos = n - 1; pos >= 0; pos--) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[pos] = leftSquare;
                left++; // Move left pointer inward
            } else {
                result[pos] = rightSquare;
                right--; // Move right pointer inward
            }
        }

        return result;
    }
}