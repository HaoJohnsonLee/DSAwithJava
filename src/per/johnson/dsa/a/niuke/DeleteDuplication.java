package per.johnson.dsa.a.niuke;

import per.johnson.dsa.a.niuke.ds.ListNode;
import per.johnson.dsa.util.AlgorithmUtils;

/**
 * Created by Johnson on 2018/7/29.
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode first = new ListNode(0);
        first.next = pHead;
        ListNode mid = pHead, last = pHead.next;
        while (last != null) {
            if (last.val != mid.val) {
                last = last.next;
                mid = mid.next;
                first = first.next;
            } else {
                while (last !=null && last.val == mid.val) {
                    last = last.next;
                }
                if (first.next == pHead) {
                    if(last == null) return null;
                    pHead = last;
                    first.next = last;
                    mid = last;
                    last = last.next;
                }else {
                    if(last == null) first.next = last;
                    else {
                        first.next = last;
                        mid = last;
                        last = last.next;
                    }
                }

            }

        }
        return pHead;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 1, 1, 1};
        ListNode root = AlgorithmUtils.array2LinkedList(a);
        ListNode head = new DeleteDuplication().deleteDuplication(root);
        System.out.println(AlgorithmUtils.linkedList2String(head));
    }

}
