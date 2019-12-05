链表：
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        n=n-m;
        while(m-1!=0){
            pre=pre.next;
            m--;
        }
        ListNode cur=pre.next;
        while(n!=0){
            ListNode curNext=cur.next;
            cur.next=cur.next.next;
            curNext.next=pre.next;
            pre.next=curNext;
            n--;
        }
        return dummy.next;
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return null;
        }
        fast=head;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
}


class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node cur=head;
        while(cur!=null){
            Node node=new Node(cur.val,null,null);
            node.next=cur.next;
            cur.next=node;
            cur=cur.next.next;
        }
        cur=head;
        while(cur!=null&&cur.next!=null){
            if(cur.random!=null){
                cur.next.random=cur.random.next;
            }
            cur=cur.next.next;
        }
        cur=head;
        Node newHead=cur.next;
        while(cur.next!=null){
            Node curNext=cur.next;
            cur.next=curNext.next;
            cur=curNext;       
        }
        return newHead;
    }
}
