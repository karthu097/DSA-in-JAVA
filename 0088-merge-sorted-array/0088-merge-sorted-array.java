class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Pointer for nums1's valid elements
        int j = n - 1; // Pointer for nums2
        int k = m + n - 1; // Pointer for the last position in nums1

        // Compare elements from the back and place the larger one at index k
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If there are remaining elements in nums2, copy them over
        // (If nums1 elements remain, they are already in their correct position)
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}