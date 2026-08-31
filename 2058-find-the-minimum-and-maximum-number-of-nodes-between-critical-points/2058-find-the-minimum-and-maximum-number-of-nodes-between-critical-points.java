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
        int first = -1;
        int previous = -1;
        int min = Integer.MAX_VALUE;
        int index = 1;
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr.next != null) {
            ListNode next = curr.next;
            // Check if curr is a critical point
            if ((curr.val > prev.val && curr.val > next.val) || (curr.val < prev.val && curr.val < next.val)) {
                // First critical point
                if (first == -1) first = index;
                // Distance from previous critical point
                if (previous != -1) min = Math.min(min, index - previous);
                previous = index;
            }
            prev = curr;
            curr = curr.next;
            index++;
        }
        // Fewer than 2 critical points
        if (first == -1 || first == previous)  return new int[]{-1, -1};
        int max = previous - first;
        return new int[]{min, max};
    }
}