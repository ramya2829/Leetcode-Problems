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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find length and tail
        ListNode tail = head;
        int len = 1;

        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // Step 2: Make circular
        tail.next = head;

        // Step 3: Find new tail
        k = k % len;
        int stepsToNewTail = len - k;

        ListNode newTail = tail;
        while (stepsToNewTail-- > 0) {
            newTail = newTail.next;
        }

        // Step 4: Break circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}