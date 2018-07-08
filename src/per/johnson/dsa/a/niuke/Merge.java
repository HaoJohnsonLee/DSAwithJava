package per.johnson.dsa.a.niuke;

import per.johnson.dsa.a.niuke.ds.ListNode;

/**
 * Created by Johnson on 2018/7/5.
 */
public class Merge {
    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     * @param list1 L1
     * @param list2 L2
     * @return new L
     */
    public static ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(list1 !=null && list2 != null){
            if(list1.val < list2.val){
                head.next = list1;
                list1 = list1.next;
            }else{
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        if(list1 == null){
            head.next = list2;
        }else{
            head.next = list1;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        ListNode head = Merge(list1,list2);

    }
}
