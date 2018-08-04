package per.johnson.dsa.a.basic;

import per.johnson.dsa.a.niuke.ds.ListNode;
import per.johnson.dsa.util.AlgorithmUtils;

/**
 * Created by Johnson on 2018/7/27.
 * 链表 荷兰国旗问题
 */
public class HolllandLinkedList {
    public static ListNode reserve(ListNode head, int value) {
        if (head == null) return null;
        ListNode tmp = head;
        ListNode less = null;
        ListNode equal = null;
        ListNode more = null;
        while (tmp != null) {
            if (less == null && tmp.val < value) {
                less = tmp;
            }
            if (equal == null && tmp.val == value) {
                equal = tmp;
            }
            if (more == null && tmp.val > value) {
                more = tmp;
            }
            tmp = tmp.next;
        }
        tmp = less;
        ListNode etmp = equal;
        ListNode mtmp = more;
        while (head != null) {
            if (head.val < value && head != less) {
                less.next = head;
                less = less.next;
            } else if (head.val == value && head != equal) {
                equal.next = head;
                equal = equal.next;
            } else if (head.val > value && head != more) {
                more.next = head;
                more = more.next;
            }
            head = head.next;
        }
        if(more!=null) more.next = null;
        if(tmp == null) {
            tmp = etmp;
            if(tmp==null){
                tmp = mtmp;
            }else{
                equal.next = mtmp;
            }
        }else{
            if(etmp == null){
                less.next = mtmp;
            }else{
                less.next = etmp;
                equal.next = mtmp;
            }
        }


        return tmp;

    }

    public static void main(String[] args) {
        for(int i = 0; i< 1000; i++) {
            int[] a = AlgorithmUtils.randomArray(10, 20);
            ListNode head = AlgorithmUtils.array2LinkedList(a);
            System.out.println(AlgorithmUtils.linkedList2String(head));
            head = reserve(head, 10);
            System.out.println(AlgorithmUtils.linkedList2String(head));
            System.out.println("--------------------------------------------------------" + i);
        }
    }
}
