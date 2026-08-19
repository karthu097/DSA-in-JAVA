import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rowSeats = new HashMap<>();
        
        // Build a bitmask for each row with reserved seats (seats 2 to 9)
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            if (col >= 2 && col <= 9) {
                rowSeats.put(row, rowSeats.getOrDefault(row, 0) | (1 << (col - 2)));
            }
        }
        
        // Start with 2 groups for every row that has NO reserved seats
        int maxGroups = (n - rowSeats.size()) * 2;
        
        // Check each row that has at least one reservation
        for (int reservedMask : rowSeats.values()) {
            boolean leftAvailable = (reservedMask & 0b00001111) == 0;   // seats 2, 3, 4, 5
            boolean rightAvailable = (reservedMask & 0b11110000) == 0;  // seats 6, 7, 8, 9
            boolean middleAvailable = (reservedMask & 0b00111100) == 0; // seats 4, 5, 6, 7
            
            if (leftAvailable && rightAvailable) {
                maxGroups += 2;
            } else if (leftAvailable || rightAvailable || middleAvailable) {
                maxGroups += 1;
            }
        }
        
        return maxGroups;
    }
}