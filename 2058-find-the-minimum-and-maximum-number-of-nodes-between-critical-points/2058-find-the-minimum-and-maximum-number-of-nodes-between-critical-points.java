/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = {-1, -1};
        
        // A minimum of 3 nodes is required to have a critical point
        if (head == null || head.next == null || head.next.next == null) {
            return result;
        }

        int minDistance = Integer.MAX_VALUE;
        int firstCriticalIndex = -1;
        int lastCriticalIndex = -1;
        
        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1; // 0-indexed, head.next is index 1

        while (curr.next != null) {
            ListNode nextNode = curr.next;
            
            // Check for local maxima or local minima
            if ((curr.val > prev.val && curr.val > nextNode.val) || 
                (curr.val < prev.val && curr.val < nextNode.val)) {
                
                if (firstCriticalIndex == -1) {
                    firstCriticalIndex = index;
                } else {
                    // Update minDistance with the distance from the last critical point
                    minDistance = Math.min(minDistance, index - lastCriticalIndex);
                }
                lastCriticalIndex = index;
            }
            
            prev = curr;
            curr = nextNode;
            index++;
        }

        // If we found at least two critical points
        if (firstCriticalIndex != -1 && firstCriticalIndex != lastCriticalIndex) {
            result[0] = minDistance;
            result[1] = lastCriticalIndex - firstCriticalIndex;
        }

        return result;
    }
}