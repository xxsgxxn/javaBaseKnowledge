package Jzoffer;

public class SumTwoNumber {
    /*不用+ - * / 做两个数的加法*/
    public int SumTwoNumber1(int num1,int num2)
    {
        /*位运算--异或和与运算左移一位是进位*/
        while (num2 != 0)
        {
            int sum = num1 ^ num2;
            int carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }
    /*不引进新变量，交换两个变量*/
    public void swap(int a,int b)
    {
        int tmp = a;
        a = b;
        b = tmp;
    }
    public void swapnovariate(int a,int b)
    {
        a = a + b;
        b = a - b;
        a = a - b;

    }
    public static void main(String[] args)
    {
        SumTwoNumber s =  new SumTwoNumber();
        int num1 = 3;
        int num2 = 4;
        s.swap(num1,num2);
        System.out.println("num1:"+num1+"   num2:"+num2);
    }
}