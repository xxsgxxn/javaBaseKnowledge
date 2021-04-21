package Jzoffer;

public class MaxDiff {
    /*{9,11,8,5,7,13,16,14}*/
    /*买卖一次获得的最大利润，就是求最大的差值，最小值在最大值前面*/
    /*找当前元素和之前最小值之间的差值*/
    public int maxProfit(int[] arr)
    {
        if (arr == null || arr.length < 2)
        {
            return 0;
        }
        int min = arr[0];
        int maxDiff = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (min > arr[i]) min = arr[i];
            int curDiff = arr[i] - min;
            if (maxDiff < curDiff) maxDiff = curDiff;
        }
        return maxDiff;

    }
}
