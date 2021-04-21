package Jzoffer;

import java.util.ArrayList;

public class NumberCountInArr {
    /*整形数组中除两个数字外，其他数字都出现了两次，找出这两个只出现一次的数字
    * 时间O(n)，空间O(1)
    * 若是只有一个数字出现了1次，则可以用0和其他的数异或
    * */
    /*对数组进行异或，得到两个不同的数的异或结果，从右往左数第m位（异或结锅从右往左的第一个为1的为）是否为1来将数组分为俩个部分
    * m=1 出现两次的数m位都为1  m位为1的一个
    * m=0 出现两次的数m位都为0  m位为0的一个
    * 两部分分别两两异或的得到两个数 */
    public ArrayList<Integer> findCountOneNumber(int[] arr)
    {
        if (arr == null || arr.length < 2) return null;
        int num1 = 0;
        int num2 = 0;
        int num = 0;/*两个数异或的结果*/
        ArrayList<Integer> res = new ArrayList<>(2);
        for (int i = 0; i < arr.length; i++)
        {
            num ^= arr[i];
        }
        int indexofOne = findFristOneIndex(num);/*从右往左第一个为1的位数*/
        for (int i = 0; i < arr.length; i++)
        {
            if (isIndexNIsOne(arr[i],indexofOne))
            {
                num1 ^= arr[i];
            }
            else{
                num2 ^= arr[i];
            }
        }
        res.add(num1);
        res.add(num2);
        return res;
    }

    public int findFristOneIndex(int n)
    {
        if (n == 0)
        {
            return -1;
        }
        int index = 0;
        while (n != 0)
        {
            int m = n%2;
            if (m == 1)
            {
                return index;
            }else{
                n = n/2;
                index++;
            }

        }
        return -1;
    }

    public boolean isIndexNIsOne(int n,int m)/*判断n的第m位是不是1*/
    {
        int res = 0;
        while (m != -1)
        {
            res = n%2;
            n = n/2;
            m--;
        }
        return res == 1 ? true : false;
    }
    public boolean isIndexNIsOne2(int n,int m)
    {
        n = n >> m;
        return (n & 1) == 1;
    }

    /*在一个数组中，只有一个数字出现一次，其它都出现3次*/
    /*采用位运算，一个int 32位，出现3次的数的每位的频率和为3整除，出现一次的数合到里面能整除说明那位为0，不能为0*/
    public int findNumInThreeArr(int[] arr)
    {
        if (arr == null || arr.length == 0) throw new RuntimeException("输入不符合");
        int frequence[] = new int[32];
        int bitmask = 1;
        /*高位存到bit[0],低位存到bit[31],从低位开始统计频率的和*/
        for (int i = 31;i >= 0;i--)
        {
            for (int number:arr)
            {
                int bit = number & bitmask;
                if (bit != 0) frequence[i] += 1;
            }
            bitmask = bitmask << 1;
        }

        /*将统计出的二进制数转变为10进制，从高位开始*/
        int res = 0;
        for (int i = 0;i < 32;i++)
        {
            res = res << 1;
            res += frequence[i] % 3;
        }
        return res;
    }

}
