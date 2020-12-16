package Jzoffer;
import java.util.LinkedList;
public class TwoStackImpQueue {
    private LinkedList<Integer> stack1 = new LinkedList<>();
    private LinkedList<Integer> stack2 = new LinkedList<>();
    public void enqueue(int e)
    {
        stack1.push(e);
    }
    public int dequeue()
    {
        if (stack1.isEmpty() && stack2.isEmpty())
        {
            throw new RuntimeException("队列为空");
        }
        if (stack2.isEmpty())
        {
            while (!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args)
    {
        TwoStackImpQueue test = new TwoStackImpQueue();
        test.enqueue(1);
        test.enqueue(2);
        test.enqueue(3);
        System.out.println(test.dequeue());
    }
}
