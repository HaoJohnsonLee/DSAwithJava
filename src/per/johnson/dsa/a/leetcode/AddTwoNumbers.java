package per.johnson.dsa.a.leetcode;

import java.util.Stack;

/**
 * Created by Johnson on 2017/11/26.
 */

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; next=null;}
    public void print(){
        ListNode cur=this;
        Stack<Integer> value=new Stack<>();
        while(cur!=null){
            value.push(cur.val);
            cur=cur.next;
        }
        while (!value.empty()){
            System.out.print(value.pop()+" ");
        }
    }
}
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode listNode=new ListNode(0);
        pre.next=listNode;
        int add=0;
        while(l1!=null||l2!=null){
            int cur=(l1!=null?l1.val:0)+(l2!=null?l2.val:0)+add;
            add=0;
            if(cur>=10){
                add=cur/10; //十位
                cur=cur%10; //个位
            }
            listNode.val=cur;
            l1=l1==null?l1:l1.next;
            l2=l2==null?l2:l2.next;
            if(l1!=null||l2!=null||add!=0){
                listNode.next=new ListNode(add);
                listNode=listNode.next;
            }

        }
        return pre.next;
    }
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        return null;
    }

    public static void main(String[] args) {
        //243 + 465
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);
        l1.next.next.next=new ListNode(6);
        l1.next.next.next.next=new ListNode(8);
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
        ListNode ln=addTwoNumbers(l1,l2);
        ln.print();
    }
}
