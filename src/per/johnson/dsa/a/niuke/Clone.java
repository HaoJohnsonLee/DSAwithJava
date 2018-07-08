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
    public RandomListNode Clone(RandomListNode pHead) {
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
        RandomListNode newHead = temp;
        while(pHead!=null){
            temp.next = pHead.next.next.next;
            pHead = temp.next.next;
            temp = temp.next;
        }
        return newHead;
    }

}
