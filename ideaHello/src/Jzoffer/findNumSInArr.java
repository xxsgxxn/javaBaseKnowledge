package Jzoffer;

import java.util.ArrayList;

public class findNumSInArr {

    /*在递增数组中找出和为S的两个数，然后输出乘积最小的那两个数，最小的一定在数组两端*/
    public int findNumSinArr1(int [] arr,int s)
    {
        int num1[] = new int[1];
        int num2[] = new int[1];
        return findNumSInArr2(arr,num1,num2,s);
    }
    private int findNumSInArr2(int[] arr,int[] num1,int[]num2,int s)
    {
        if (arr.length < 2)
        {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low < high)
        {
            if (arr[low] + arr[high] > s)
            {
                high--;

            }else if (arr[low] + arr[high] < s)
            {
                low--;
            }else{
                num1[0] = arr[low];
                num2[0] = arr[high];
                return 0;
            }
        }
        return -1;/*未找到*/
    }

    /*打印和为s的所有连续整数序列*/
    /*从1开始，每次增加大的数，增加到的curSum == sum时，就加入list中，当curSum比sum大时，不断丢弃最小的数*/
    /*最小的数不会超过s的一半*/
    public ArrayList<ArrayList<Integer>> PrintContinuousPositiveNumberSequence(int s)
    {
        ArrayList<ArrayList<Integer>> seq = new ArrayList<>();
        if (s <= 2) return seq;
        int small = 1;
        int big = 2;
        int curSum = small + big;
        int mid = (s + 1) /2;
        while (small < mid)
        {
            /*先判断curSum是否比s小，小就丢弃small*/
            while (small < mid && curSum > s)
            {
                curSum -= small;
                small++;
            }
            if (curSum == s) seq.add(addNumberSeqInList(small,big));

            big++;
            curSum += big;
        }
        return seq;
    }
    public ArrayList<Integer> addNumberSeqInList(int small,int big)
    {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = small; i <= big; i++)
        {
            list.add(i);
        }
        return list;
    }
    public static void main(String[] args)
    {
        findNumSInArr f = new findNumSInArr();
        System.out.println(f.PrintContinuousPositiveNumberSequence(9));
    }

}
