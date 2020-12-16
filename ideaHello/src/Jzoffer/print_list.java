package Jzoffer;
import java.util.ArrayList;
import java.util.Stack;
class ListNode{
    int val;/*节点的值，包内部访问权限*/
    ListNode next = null;
    ListNode(int val)
    {
        this.val = val;
    }
}
public class print_list {


    public ArrayList<Integer> print_list_from_tail_to_head1(ListNode list)
    {
        /*使用栈来打印*/
        if (list == null)
        {
            return null;
        }
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> a = new ArrayList<>();
        for (ListNode p = list;p!=null;p=p.next)
        {
            s.push(p.val);
        }
        while(!s.isEmpty())
        {
            a.add(s.pop());
        }
        return a;
    }
    public static void main(String[] args)
    {
        print_list p = new print_list();
        ListNode head = new ListNode(0);
        ListNode hp = head;
        for (int i=1;i<5;i++)
        {
            ListNode q = new ListNode(i);
            hp.next = q;
            hp = q;
        }

        System.out.println(p.print_list_from_tail_to_head1(head).toString());

    }
}
