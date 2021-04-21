package Jzoffer;

import java.util.*;

public class MaxValSlidingWindow {
    /*滑动窗口最大值，{2,3,4,2,6,2,5} 窗口为3,{4,4,6,6,6,5}*/
    /*采用大顶堆，优先队列*/
    public ArrayList<Integer> maxvalInWindowPriority(int[] arr,int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if (arr == null || arr.length < size || size <= 0) return list;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int j = 0;
        for (int i = 0;i < arr.length;i++)
        {
            queue.offer(arr[i]);
            if (queue.size() >= size)
            {
                list.add(queue.peek());
                queue.remove(arr[j++]);
            }
        }
        return list;
    }
   /*实现一个队列，有max方法，进，出，max时间复杂度为o(1)*/
    Deque<Integer> queue = new LinkedList<>();
    Deque<Integer> maxqueue = new LinkedList<>();
    public int maxValQueue()
    {
        if (maxqueue.isEmpty()) throw new RuntimeException("队列已空");
        return maxqueue.peekFirst();
    }
    public void enqueue(int ele)
    {
        if (queue.isEmpty())
        {
            queue.offerLast(ele);
            maxqueue.offerFirst(ele);
            return;
        }
        queue.offerLast(ele);
        if (ele > maxqueue.peekFirst())
        {
            maxqueue.offerFirst(ele);
        }
        else{
            maxqueue.offerFirst(maxqueue.peek());
        }
    }
    public int delqueue()
    {
        if (queue.isEmpty())
        {
            throw new RuntimeException("队列已空");
        }
        queue.poll();
        maxqueue.poll();
        return 0;
    }
}
