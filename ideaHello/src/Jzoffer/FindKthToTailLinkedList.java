package Jzoffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindKthToTailLinkedList {
    public ListNode findKthTailNode(ListNode head,int k)
    {
        if (head == null)
        {
            return null;
        }
        ListNode a = head;
        for (int i=0;i < k-1;i++)
        {
            if (a.next == null)
            {
                return null;
            }
            a = a.next;
        }
        ListNode b = head;
        while (a.next != null)
        {
            a = a.next;
            b = b.next;
        }
        return b;
    }
    /*环的入口节点*/
    public ListNode ringInList(ListNode head)
    {
        if (head == null)
        {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null )
        {
            if (slow == fast)
            {
                fast = head;
                while (fast != slow)
                {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;

    }
    public ListNode ringInListSet(ListNode head)
    {
        if (head == null)
        {
            return null;
        }
        ListNode p = head;
        /*Set是抽象类，不可实例化*/
        Set<ListNode> listset = new HashSet<>();
        while (p.next != null)
        {
            if (!listset.add(p))
            {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    public ListNode ringInListMap(ListNode head)
    {
        if (head == null)
        {
            return null;
        }
        ListNode cur = head;
        Map<ListNode,Boolean> listmap = new HashMap<>();
        while (cur.next != null)
        {
            if (listmap.containsKey(cur))
            {
                return cur;
            }
            listmap.put(cur,true);
            cur = cur.next;
        }
        return null;
    }

    /*反转链表*/
    public ListNode reversalList(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        /*采用头插法来逆置单链表*/
        ListNode cur = head;
        ListNode next = null;//当前节点的下一个节点
        ListNode pre = null;
        while (cur != null)
        {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }

    public ListNode reversalListRecur(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        ListNode p = reversalListRecur(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /*合并两个有序链表，用归并的方法*/
    public ListNode mergeOrderedList(ListNode head1,ListNode head2)
    {
        if (head1 == null)
        {
            return head2;
        }
        if (head2 == null)
        {
            return head1;
        }
        ListNode head = null;
        if (head1.val <= head2.val)
        {
            head = head1;
        }else{
            head = head2;
        }
        ListNode pre = head;
        while (head1 != null && head2 != null)
        {
            if (head1.val >= head2.val)
            {

                    pre.next = head1;
                    pre = pre.next;
                    head1 = head1.next;
            }
            else{

                    pre.next = head2;
                    pre = pre.next;
                    head2 = head.next;
            }
        }
        if (head1 != null)
        {
            pre.next = head1;
        }
        if (head2 != null)
        {
            pre.next = head2;
        }
        return head;
    }
    public ListNode mergeOrderedListRecur(ListNode head1,ListNode head2)
    {
        if (head1 == null)
        {
            return head2;
        }
        if (head2 == null)
        {
            return head1;
        }
        ListNode head = null;
        if (head1.val <= head2.val)
        {
            head = head1;
            head.next = mergeOrderedListRecur(head1.next,head2);
        }else{
            head = head2;
            head.next = mergeOrderedListRecur(head1,head2.next);
        }
        return head;
    }


}
