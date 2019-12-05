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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        int len=getLen(head);
        if(k==0||k%len==0){
            return head;
        }
        ListNode cur=head;
        
        k%=len;
        while((len-k-1)!=0){
            cur=cur.next;
            k++;
        }
        ListNode newHead=cur.next;
        cur.next=null;
        ListNode curNext=newHead;
        while(curNext.next!=null){
            curNext=curNext.next;
        }
        curNext.next=head;
        return newHead;
    }

    private int getLen(ListNode head){
        ListNode cur=head;
        int len=0;
        while(cur!=null){
            cur=cur.next;
            len++;
        }
        return len;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode cur=head;
        while(cur!=null){
            if(cur.next!=null&&cur.val==cur.next.val){
                while(cur.next!=null&&cur.val==cur.next.val){
                    cur=cur.next;
                }
                pre.next=cur.next;
                cur=cur.next;
            }else{
                pre=cur;
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return null;
        }
        ListNode pB=null;
        ListNode after=pB;
        ListNode pS=null;
        ListNode before=pS;
        ListNode cur=head;
        while(cur!=null){
            ListNode curNext=cur.next;
            cur.next=null;
            if(cur.val<x){
                if(pS==null){
                    pS=cur;
                    before=cur;  
                }else{
                    before.next=cur;
                    before=before.next;
                }
            }else{
                if(pB==null){
                    pB=cur;
                    after=cur;
                }else{
                    after.next=cur;
                    after=after.next;
                }   
            }
            cur=curNext;
        }
        if(pS!=null){
            before.next=pB;
            return pS;
        }
        return pB;
    }
}