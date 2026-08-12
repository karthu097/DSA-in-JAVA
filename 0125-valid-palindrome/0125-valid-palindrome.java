class Solution {
    public boolean isPalindrome(String s) {

    int left = 0;
    int right = s.length() - 1;

    while (left < right) {

        // Skip invalid character on left
        if (!Character.isLetterOrDigit(s.charAt(left))) {
            left++;
            continue;
        }

        // Skip invalid character on right
        if (!Character.isLetterOrDigit(s.charAt(right))) {
            right--;
            continue;
        }

        // Compare after skipping invalid characters
        if (Character.toLowerCase(s.charAt(left))
                != Character.toLowerCase(s.charAt(right))) {
            return false;
        }

        // Move both pointers
        left++;
        right--;
    }

    return true;
}
}