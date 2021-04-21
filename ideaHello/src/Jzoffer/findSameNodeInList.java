package Jzoffer;

public class findSameNodeInList {
    /*一种方法是利用两着之间的节点数之差，将长节点走m-n后，后面两者一起走*/
    public ListNode findFristSameNode1(ListNode list1,ListNode list2)
    {
        if (list1 == null || list2 == null)
        {
            return null;
        }
        ListNode p1 = list1;
        ListNode p2 = list2;
        int l1 = 0,l2 = 0;
        while (p1 != null)
        {
            l1++;
            p1 = p1.next;
        }
        while (p2 != null)
        {
            l2++;
            p2 = p2.next;
        }
        int m;
        ListNode long_list;
        ListNode short_list;
        if (l1 >= l2)
        {
            m = l1 - l2;
            long_list = list1;
            short_list = list2;
        }else{
            long_list = list2;
            short_list = list1;
            m = l2 - l1;
        }

        while (m > 0)
        {
            long_list = long_list.next;

        }
        while(long_list != null && short_list != null)
        {
            if (long_list == short_list)
            {
                return long_list;
            }
        }
        return null;
    }
    /*另一种办法就是 遍历当list1完了之后立即换list2的头，list2完了之后立即换list1的头
    * 交替着走
    * */
    public ListNode findFirstSameNode2(ListNode list1,ListNode list2)
    {
        if (list1 == null || list2 == null)
        {
            return null;
        }
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != p2)
        {
            p1 = (p1 == null) ? list2 : list1.next;
            p2 = (p2 == null) ? list1 : list2.next;
        }
        return p1;
    }

}
