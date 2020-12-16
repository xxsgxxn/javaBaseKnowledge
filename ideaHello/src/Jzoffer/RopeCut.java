package Jzoffer;
import java.lang.Math;
public class RopeCut {
    public static int dpRopeCut(int len)
    {
        if (len <= 2)
        {
            return 0;
        }
        if (len == 2)
        {
            return 1;
        }
        if (len == 3)
        {
            return 2;
        }
        int[] resultRope = new int[len + 1];
        resultRope[1] = 1;
        resultRope[2] = 2;//绳子长度
        resultRope[3] = 3;
        for (int i = 4; i <= len;i++)
        {
            int max = 0;
            for (int j = 1;j <= i/2;j++)//找出乘积最大的
            {
                if (max < resultRope[j]*resultRope[i-j])
                {
                    max = resultRope[j]*resultRope[i-j];
                }

            }
            resultRope[i] = max;
        }
        return resultRope[len];
    }
    public static int greedyRopeCut(int len)
    {
        if (len < 2)
        {
            return 0;
        }
        if (len == 2)
        {
            return 1;
        }
        if (len == 3)
        {
            return 2;
        }
        int times3 = len/3;//被分成3段的数目
        if (len - 3*times3 == 1)
        {
            times3--;
        }
        int times2 = (len - 3*times3)/2;
        return (int) Math.pow(3,times3) * (int) Math.pow(2,times2);

    }
    public static void main(String[] args)
    {
        int len = 8;
        System.out.println("动态规划："+dpRopeCut(len));
        System.out.println("贪心："+greedyRopeCut(len));

    }
}
