package per.johnson.dsa.a.niuke;

import per.johnson.dsa.a.niuke.ds.ListNode;

/**
 * Created by Johnson on 2018/7/27.
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead == null || pHead.next ==null || pHead.next.next==null)return null;
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(fast!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                fast = pHead;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
