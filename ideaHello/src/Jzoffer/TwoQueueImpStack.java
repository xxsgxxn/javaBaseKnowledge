package Jzoffer;
import java.util.LinkedList;
import java.util.Queue;
public class TwoQueueImpStack {
    private Queue<Integer> a = new LinkedList<>();
    private Queue<Integer> another = new LinkedList<>();
    public void push(int e)
    {
        if(a.isEmpty()&&another.isEmpty())
        {
            a.offer(e);
        }else if(!another.isEmpty())
        {
            another.offer(e);
        }else{
            a.offer(e);
        }
    }
    public int pop()
    {
        if (a.isEmpty()&&another.isEmpty())
        {
            throw new RuntimeException("栈为空");
        }else if (!another.isEmpty()){
            int size = another.size();
            for (int i=0;i<size-1;i++)
            {
                a.offer(another.poll());
            }
            return another.poll();
        }else{
            int size = a.size();
            for (int i = 0;i<size-1;i++)
            {
                another.offer(a.poll());
            }
            return a.poll();
        }
    }
    public static void main(String[] args)
    {
        TwoQueueImpStack s = new TwoQueueImpStack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
