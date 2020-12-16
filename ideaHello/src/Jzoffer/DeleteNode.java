package Jzoffer;


public class DeleteNode {

    public ListNode deleteNodeO1(ListNode head,ListNode tobeDel)
    {
        if (head == null || tobeDel == null)
        {
            return head;
        }
        if (head == tobeDel)
        {
            head = head.next;
            return head;
        }else if (tobeDel.next != null) {
            tobeDel.val = tobeDel.next.val;
            tobeDel.next = tobeDel.next.next;

    }else{//尾节点
            ListNode cur = head;
            while (cur.next != tobeDel&&cur != null)
            {
                cur = cur.next;
            }
            cur.next = null;
        }
        return head;
    }

    public ListNode deleteRepeatNode1(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null&&cur.next != null)
        {
            int val = cur.val;
            if (val == cur.next.val)
            {
                while (cur != null &&cur.next.val == val)
                {
                    cur = cur.next;
                }
                if (pre == null)//头节点为重复节点
                {
                    head = cur;
                }else{
                    pre.next = cur;
                }
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    public ListNode deleteRepeateNode2(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode first = new ListNode(head.val - 1);
        first.next = head;
        ListNode pre = first;
        ListNode cur = head;
        while (cur != null && cur.next != null)
        {
            int val = cur.val;
            while (cur != null &&cur.next!=null&& cur.val == cur.next.val)
            {
                cur = cur.next;
            }
            pre.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return first.next;
    }
    public static void main(String[] args)
    {
        DeleteNode test = new DeleteNode();
        ListNode head = new ListNode(1);
        ListNode pre = head;
        ListNode p = new ListNode(1);
        pre.next = p;
        pre = pre.next;
        ListNode p2 = new ListNode(2);
        pre.next = p2;
        pre = pre.next;
        ListNode p3 = new ListNode(2);
        pre.next = p3;
        pre = pre.next;
        ListNode cur = test.deleteRepeateNode2(head);
        while (cur != null)
        {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
