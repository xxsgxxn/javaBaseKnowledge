package Jzoffer;

public class AdigitInNumberSeq {
    /*再字符序列中出现的索引为index的数字*/
    private int countDigits(int n)/*计算每个数有多少位*/
    {
        int count = 0;
        while (n != 0)
        {
            count++;
            n = n/10;
        }
        return count;
    }

    private int indexOfNum(int n,int k)/*返回数字k位上的数*/
    {
        return (n / (int) Math.pow(10,k)) % 10;
    }

    public int digitAtSeq1(int index)
    {
        if (index < 0)
        {
            return -1;
        }
        int i = 0;
        int len = 0;
        while (true)
        {
            if (len > index) break;
            len += countDigits(i);
            i++;
        }
        return indexOfNum(i,len-index-1);
    }

    public int digitAtSeq2(int index)
    {
        if (index < 0)
        {
            return -1;
        }
        /*先要缩小index得范围*/
        int digits = 1;/*从位数为1开始计算*/
        while (true){
            int number = digits * digitRange(digits);/*数量乘位数就是长度*/
            if (index < number)
            {
                return indexOfNum2(digits,index);
            }
            index -= number;
            digits++;
        }
    }
    public int indexOfNum2(int digits,int index)
    {
        int begin = beginNum(digits);
        return indexOfNum(begin + index / digits,digits-index%digits-1);
    }
    public int beginNum(int digits)
    {
        if (digits == 1)
        {
            return 0;
        }
        return (int)Math.pow(10,digits-1);
    }

    public int digitRange(int digits)
    {
        if (digits == 1) return 10;/*0~9*/
        return 9*(int)(Math.pow(10,digits-1));
    }
}