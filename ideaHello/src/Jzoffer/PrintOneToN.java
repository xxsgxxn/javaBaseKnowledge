package Jzoffer;
import java.lang.StringBuilder;
public class PrintOneToN {

    /*从1开始打印到最大的n位数*/
    public static void Print(int n)
    {
        if (n <= 0)
        {
            return;
        }
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0;i < n;i++)
        {
            sb.append("0");
        }
        while (increaseStill(sb,n))
        {
            print(sb);
        }
        System.out.println();
    }
    public static void print(StringBuilder sb)
    {
        int start = sb.length();
        for (int i = 0;i < sb.length();i++)
        {
            if (sb.charAt(i) != '0')
            {
                start = i;
                break;
            }
        }
        if (start < sb.length())
        {
            System.out.print(sb.substring(start)+" ");
        }

    }
    public static boolean increaseStill(StringBuilder sb,int len)
    {
        if (len <= 0)
        {
            return false;
        }
        int token = 0;//进位
        for (int i = len - 1;i>=0;i--)
        {
            int sum = sb.charAt(i) - '0' + token;
            if (i == len - 1)
            {
                sum++;
            }
            if (sum == 10)//需要进位
            {
                if (i == 0)
                {
                    return false;
                }else {
                    token = 1;
                    sb.setCharAt(i,'0');
                }
            }else{
                sb.setCharAt(i,(char) (sum + '0'));
                break;
            }
        }

            return true;
    }
    private static void printN(StringBuilder sb, int index, int len)//设置当前位然后递归
    {
        if (index == len)
        {
            print(sb);
            return;
        }
        for (int i = 0;i < 10;i++)
        {
            sb.setCharAt(index,(char)(i + '0'));
            printN(sb,index + 1,len);
        }
    }
    public static void printN ( int n)
    {
        if (n <= 0)
        {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < n;i++)
        {
            sb.append("0");
        }
        printN(sb,0,n);
    }
    public static void main(String[] args)
    {
        int n = 3;
        Print(n);

        printN(n);
    }
}
