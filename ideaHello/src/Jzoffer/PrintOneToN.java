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

    /*统计1~n中1出现的个数
    * 法1：计算每个数字中1的个数，然后相加
    * 法2：用StringBuilder拼接每个数字，然后计算其中1的个数
    * 法3：固定1的位，计算每种情况*/
    private int countOne(int n)
    {
        int count = 0;
        while (n != 0)
        {
            if (n % 10 == 1)
            {
                count += 1;
            }
            n = n/10;
        }
        return count;
    }

    public int countOne1(int n)
    {
        int count = 0;
        for (int i=1;i<=n;i++)
        {
            count += countOne(i);
        }
        return count;
    }

    public int countOne2(int n)
    {
        int count=0;
        if (n<0) n = Math.abs(n);
        StringBuilder s = new StringBuilder();
        for (int i=1;i<=n;i++)
        {
            s.append(i);
        }
        for (int i=0;i<s.length();i++)
        {
            if (s.charAt(i) == '1') {
                count++;

            }
        }
        return count;
    }

    public int countOne3(int n)
    {
        int ones = 0;
        for (int m = 1;m<=n;m=m*10)
        {
            int a = n/m;
            int b = n%m;
            if (a%10 ==0){
                ones += (a/10)*m;
            }else if(a%10 == 1)
            {
                ones += (a/10)*m + (b+1);
            }else{
                ones += (a/10 + 1) * m;
            }
        }
        return ones;
    }



    

}
