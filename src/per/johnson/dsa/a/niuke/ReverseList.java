package per.johnson.dsa.a.niuke;

/**
 * Created by Johnson on 2018/7/5.
 */
public class ReverseList {
    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     * @param head 源 head
     * @return 反转 head
     */
    public static ListNode ReverseList(ListNode head) {
        if(head == null) return null;
        ListNode pre = head.next;
        ListNode last = head;
        while(pre != null){
            ListNode temp = pre;
            pre = pre.next;
            temp.next = last;
            last = temp;
        }
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode re = ReverseList(head);
    }
}
