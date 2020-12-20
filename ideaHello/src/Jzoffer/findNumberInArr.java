package Jzoffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

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


    /*下沉*/
    private void  sink(int[] arr,int k,int N)//
    {
        while (2*k <= N)
        {
            int j = 2 * k;
            if (j<N&&arr[j-1] > arr[j]) j++;
            if (arr[k-1] < arr[j-1]) break;
            int temp = arr[k-1];
            arr[j-1] = temp;
            arr[k-1] = arr[j-1];
            k = j;
        }
    }
    public ArrayList<Integer> findMinKth2(int[]a,int k)
    {
        int N = a.length;
        ArrayList<Integer> res = new ArrayList<>();
        if (a == null || k <= 0)
        {
            return res;
        }
        for (int i = N/2;i >= 1;i++)//构造小顶堆
        {
            sink(a,i,N);
        }
        for (int i = 0;i < k;i++)
        {
            res.add(a[0]);
            int temp = a[0];
            a[0] = a[N-1];
            a[N-1] = temp;
            N--;
            sink(a,1,N);
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

    /*基于最大堆的优先序列，一旦堆中元素超过k个 就剔除里面最大的，最后遍历完全部元素，剩下的就是最小的K个*/
    public ArrayList<Integer> findKthMin4(int[] a,int k)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if (a == null || a.length < k || a.length == 0 || k <= 0)
        {
            return res;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0;i < a.length;i++)
        {
            q.add(a[i]);
            if (q.size() > k)
            {
                q.poll();
            }
        }
        res.addAll(q);
        return res;
    }

    /*连续子数组的最大和
    * 当前和小于零，就该重新计算当前和了*/
    public int SumSubArr(int[] a)
    {
        if (a == null || a.length == 0)
        {
            return 0;
        }
        int curSum = 0;
        int maxSum = 0;
        for (int i=0;i<a.length;i++)
        {
            if (curSum +a[i] < a[i]){
                curSum = a[i];
            }else{
                curSum += a[i];
            }
            if (maxSum < curSum)
            {
                maxSum = curSum;
            }
        }
        return maxSum;
    }

    public int SumSubArrdfs(int[] Arr)
    {
        if (Arr== null || Arr.length == 0)
        {
            return 0;
        }
        int curSum = 0;
        int maxSum = 0;
        for (int i = 0;i < Arr.length;i++)
        {
            curSum = Math.max(curSum+Arr[i],Arr[i]);
            maxSum = Math.max(curSum,maxSum);
        }
        return maxSum;
    }



}
