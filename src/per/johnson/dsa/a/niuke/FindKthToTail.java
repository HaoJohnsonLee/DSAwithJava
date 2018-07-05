package per.johnson.dsa.a.niuke;

/**
 * Created by Johnson on 2018/7/5.
 */
public class FindKthToTail {
    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     * @param head head
     * @param k 倒数第 K 个
     * @return {@link ListNode}
     */
    public ListNode FindKthToTail_0(ListNode head,int k) {
        ListNode[] temp = new ListNode[64];
        int size = 0;
        while(head != null){
            temp[size++] = head;
            head = head.next;
        }
        if(size<k)return null;
        return temp[size-k];
    }
    public static ListNode FindKthToTail_1(ListNode head,int k) {
        ListNode pre = head;
        ListNode last = head;
        if(k == 0) return null;
        while (k-- > 1) {
            if (pre == null)
                return null;
            pre = pre.next;
        }
        while (pre.next != null) {
            pre = pre.next;
            last = last.next;
        }
        return last;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode p = FindKthToTail_1(head,6);
    }
}
