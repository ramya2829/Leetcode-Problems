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
    public ListNode middleNode(ListNode head) {
        List<ListNode>l1=new ArrayList<>();
        ListNode p=head;
        ListNode q=head;
        while(q!=null && q.next!=null){
            q=q.next.next;
            p=p.next;
        }
        return p;
             
    }
}