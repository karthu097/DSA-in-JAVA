class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;
        
        for (int num : nums1) {
            if (num % 2 != 0) {
                if (num < minOdd) minOdd = num;
            } else {
                if (num < minEven) minEven = num;
            }
        }
        
        // If the array is already all odd or all even
        if (minOdd == Integer.MAX_VALUE || minEven == Integer.MAX_VALUE) {
            return true;
        }
        
        // The smallest odd number cannot be made even, so the target parity must be odd.
        // We can only make even numbers odd if there is a smaller odd number to subtract from them.
        return minEven > minOdd;
    }
}