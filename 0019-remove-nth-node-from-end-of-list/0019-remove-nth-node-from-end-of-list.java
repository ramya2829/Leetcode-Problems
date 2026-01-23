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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<Integer>l1=new ArrayList<>();
        ListNode p=head;
        if(head==null||head.next==null){
            return null;
        }
        
        int count=0,i=0;
        
        while(p!=null){
            p=p.next;
            count++;
           
        }
        int x=count-n;
        if(x==0){
           ListNode temp=head;
           head=temp.next;
           temp.next=null;
           return head; 
        }
        ListNode p1=head;
        ListNode q=head;
        while(x!=0 && p1!=null){
        q=p1;
        p1=p1.next;
        x--;
    }
    q.next=p1.next;
    p1.next=null;
    return head;
        
    }
}