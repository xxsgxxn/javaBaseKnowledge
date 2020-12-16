package Jzoffer;

import java.util.ArrayList;

public class findNumberInArr {
    /*找出数组中出现次数超一半的数字，并
     * 切分法找中位数*/
    public int partation(int[] a, int low, int high) {
        int i = low;
        int j = high;
        int key = a[low];
        while (i < j) {
            while (i <= j && a[i] <= key) {
                i++;
            }
            while (i <= j && a[j] >= key) {
                j--;
            }
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        a[low] = a[j];
        a[j] = key;
        return j;
    }

    public boolean checkoutNum(int[] a, int key)/*检查是否超过数组个数的一半*/
    {
        if (a == null)
        {
            return false;
        }
        int count = 0;
        for (int i = 0;i<a.length;i++)
        {
            if (key == a[i])
            {
                count++;
            }
        }
        return count > (a.length/2) ? true : false;
    }

    public int findNumMuch(int[] a)
    {
        int low = 0;
        int high = a.length-1;
        while(low<high)
        {
            int j = partation(a,low,high);
            if (j == a.length/2) return a[j];
            if (j < a.length/2) low = j + 1;
            if (j > a.length/2) high = j - 1;
        }
        return a[a.length/2];
    }
    public int findMuchHalfNum(int[] a)
    {
        int res = findNumMuch(a);
        if (checkoutNum(a,res))
        {
            return res;
        }
        return -1;
    }

    /*第二种：遍历每个数字，统计个数，等于的话count+1，不等的话减一，当count为零时重新确定一个数*/
    public int findNumThanHalf(int[] a)
    {
        if (a == null || a.length == 0)
        {
            return 0;
        }
        int res = a[0];
        int count = 1;
        for (int i = 1;i < a.length;i++)
        {
            if (count == 0)
            {
                res = a[i];
                count = 1;
            }else if (a[i] == res)
            {
                count++;
            }else{
                count--;
            }
        }
        if (checkoutNum(a,res))
        {
            return res;
        }
        return -1;
    }


    /*找出数组中最小的k个数*/
    /*法一,切分法找*/
    /*法二，小顶堆*/
    /*法三部分冒泡排序*/
    public int select(int[] a,int k)/*找出数组中排名为k的元素*/
    {
        int low = 0;
        int high = a.length - 1;
        while(low < high)
        {
            int j = partation(a,low,high);
            if (j == k) return a[k];
            if (j > k) high = j -1;
            if (j < k) low = j + 1;
        }
        return a[k];
    }

    public ArrayList<Integer> findMinKNum1(int[] a,int k)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if (a == null || k <= 0)
        {
            return res;
        }
        select(a,k-1);
        for (int i = 0; i < k;i++)
        {
            res.add(a[i]);
        }

        return res;
    }

    /*部分冒泡排序*/
    public ArrayList<Integer> findMinKth3(int[] a,int k)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if (a == null || k <= 0)
        {
            return res;

        }
        for (int i = 0;i < k;i++)
        {
            for (int j = a.length-1;j>i;j--)
            {
                if (a[j] < a[j-1])
                {
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int i = 0;i < k;i++)
        {
            res.add(a[i]);
        }
        return res;
    }

}
