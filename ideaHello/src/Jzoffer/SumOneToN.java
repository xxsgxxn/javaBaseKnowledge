package Jzoffer;

/*求1~n的,不能循环，不能用for while等词，和乘除等三元运算*/
public class SumOneToN {
    /*递归*/
    public int SumOneToN1(int n)
    {
        int sum = n;
        boolean b = n > 0 && (sum += SumOneToN1(n - 1)) > 0;
        return sum;
    }
    /*等差数列 加法和位运算*/
    /*n(n+1)/2=(n^2+n)>>1*/
    public int SumOneToN2(int n)
    {
        return (int)(Math.pow(2,n) + n) >> 1;
    }
}
