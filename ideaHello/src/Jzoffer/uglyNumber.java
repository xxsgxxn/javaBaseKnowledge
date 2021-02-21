package Jzoffer;

public class uglyNumber {
    /*求第n个丑数*
    有一天也许会走远，1，1*2,1*3，1*5，选了最小的2那么下个和2相乘的数应该是下一个丑数*/
    public int getUglyNumber(int n)
    {
        if (n <= 0)
        {
            return 0;
        }
        if (n == 1)
        {
            return 1;
        }
        int ugly[] = new int[n];
        ugly[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        for (int i = 1;i < n;i++)
        {
            int m2 = ugly[index2] * 2;
            int m3 = ugly[index3] * 3;
            int m5 = ugly[index5] * 5;
            ugly[i] = Math.min(m2,Math.min(m3,m5));
            if (ugly[i] == m2){
                index2++;
            }else if (ugly[i] == m3)
            {
                index3++;
            }else {
                index5++;
            }
        }
        return ugly[n-1];
    }

}
