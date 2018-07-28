package per.johnson.dsa.a.niuke;

import per.johnson.dsa.a.niuke.ds.ListNode;

/**
 * Created by Johnson on 2018/7/28.
 *
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2==null) return null;
        int height = 0 , s;
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while(node1 !=null){
            height++;
            node1 = node1.next;
        }
        while(node2 !=null){
            height--;
            node2 = node2.next;
        }
        if(height > 0){  // list 1 长
            s = height;
            while(s > 0){
                pHead1 = pHead1.next;
                s --;
            }

        }else{  // list 2 长
            s = -height;
            while(s > 0){
                pHead2 = pHead2.next;
                s --;
            }
        }
        while(pHead1!=pHead2){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }
}
