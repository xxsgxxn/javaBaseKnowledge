package Jzoffer;

public class oneSum {
    public static int oneSumIn(int n)
    {
        int count = 0;
        int flag = 1;
        while (flag != 0)
        {
            if ((flag&n)!=0)
            {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static int numberOf1(int n)
    {
        int count = 0;
        while (n != 0)
        {
            n = n & (n-1);
            count++;
        }
        return count;
    }
    public static void main(String[] args)
    {
        System.out.println("移位："+oneSumIn(9));
        System.out.println("减一与原数与："+numberOf1(9));
    }
}
