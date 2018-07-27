package per.johnson.dsa.a.niuke;

import per.johnson.dsa.a.niuke.ds.RandomListNode;

/**
 * Created by Johnson on 2018/7/6.
 */
public class Clone {
    /**
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）
     * 返回结果为复制后复杂链表的head。
     * @param pHead 头结点
     * @return
     */
    public static RandomListNode Clone(RandomListNode pHead) {
        RandomListNode temp = pHead;
        //复制链表
        while(temp!=null){
            RandomListNode p = new RandomListNode(temp.label);
            p.next = temp.next;
            temp.next = p;
            temp = p.next;
        }
        temp = pHead;
        //复制 random
        while (temp!=null){
            temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
        //切分
        temp = pHead.next;
        RandomListNode oldHead = pHead;
        RandomListNode newHead = temp;
        while(temp.next!=null){
            pHead.next = temp.next;
            pHead = pHead.next;
            temp.next = pHead.next;
            temp = temp.next;
        }
        pHead.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(5);
        RandomListNode t1 = new RandomListNode(4);
        RandomListNode t2 = new RandomListNode(3);
        RandomListNode t3 = new RandomListNode(2);
        RandomListNode t4 = new RandomListNode(1);
        head.next = t1;
        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        head.random = t3;
        t1.random = t4;
        t2.random = t3;
        t3.random = t1;
        t4.random = head;
        RandomListNode result = Clone(head);
    }

}
