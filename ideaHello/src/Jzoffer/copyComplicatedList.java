package Jzoffer;
class CListNode {
    int val;
    CListNode next;
    CListNode random;
    public CListNode(int val)
    {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class copyComplicatedList {
    /*复杂链表的复制*
    插入，连接，拆分*/
    public CListNode complicatedListCopy(CListNode head)
    {
        if (head == null)
        {
            return null;
        }
        CListNode cur = head;
        /*插入*/
        while (cur != null)
        {
            CListNode p = new CListNode(cur.val);
            p.next = cur.next;
            cur.next = p;
            cur = p.next;
        }
        cur = head;
        CListNode new_cur = cur.next;
        /*连接*/
        while (cur != null)
        {
            new_cur.random = cur.random.next;
            cur = cur.next.next;
            new_cur = new_cur.next.next;
        }

        /*拆分*/
        cur = head;
        CListNode new_head = cur.next;
        new_cur = new_head;
        while (cur != null)
        {
            cur.next = cur.next.next;
            if (new_cur.next != null)
            {
                new_cur.next = new_cur.next.next;
            }
            cur = cur.next;
            new_cur = new_cur.next;
        }
        return new_head;
    }
}
