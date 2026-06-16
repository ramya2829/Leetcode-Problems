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
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode cu= head;
        while(cu!=null && cu.next!=null){
            if(cu.val==cu.next.val){
                cu.next=cu.next.next;
            }
            else{
                cu=cu.next;
            }
        }
        return head;
        
    }
}
