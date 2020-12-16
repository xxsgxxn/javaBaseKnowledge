package Jzoffer;

import java.util.LinkedList;

public class StackOfMin {
    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> stackMin = new LinkedList<>();
    public void pushStackMin(int e)
    {
        if (stackMin.isEmpty() || e < stackMin.peek())
        {
            stackMin.push(e);
        }else{
            stackMin.push(stackMin.peek());
        }
        stack.push(e);
    }

    public int popStackMin()
    {
        if (stack.isEmpty()){
            throw new RuntimeException("Stack is empty!");
        }
        stackMin.pop();
        return stack.pop();
    }
    public int minElement()
    {
        if (stackMin.isEmpty())
        {
            throw new RuntimeException("stack is empty!");
        }
        return stackMin.peek();
    }


    public boolean ispopOrder(int[] pushA,int[] popA)
    {
        if (pushA == null || popA == null || pushA.length == 0||popA.length == 0)
        {
            return false;
        }
        LinkedList<Integer> s = new LinkedList<>();
        int popIndex = 0;
        for (int i = 0;i<pushA.length;i++)
        {
            s.push(pushA[i]);
            while (!s.isEmpty()&&s.peek()==popA[popIndex])
            {
                popIndex++;
                s.pop();
            }
        }
        return s.isEmpty();
    }
}
