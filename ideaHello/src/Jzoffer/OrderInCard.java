package Jzoffer;

import java.lang.reflect.Array;
import java.util.Arrays;

public class OrderInCard {
    /*扑克牌中的顺子，当大小王的数目》=间隔的数字，就可以构成顺子*/
    public boolean isOrderInCard(int[] numbers)
    {
        /*为null或数目不是5就直接返回true*/
        if (numbers == null || numbers.length != 5) return false;
        int joker=0;/*大小王的个数*/
        Arrays.sort(numbers);
        /*大小王最多4个*/
        for (int i = 0; i < 4; i++)
        {
            if (numbers[i] == 0) joker++;
        }
        int totalInterval = 0;/*计算总的间隔，1，2之间无间隔就0，13之间间隔2，则间隔数就1*/
        for (int i = numbers.length - 1; i > joker; i--)
        {
            if (numbers[i] == numbers[i-1]) return false;/*出现对子*/
            else{
                totalInterval += numbers[i] - numbers[i-1] - 1;
            }
        }
        if (joker >= totalInterval) return true;
        return false;
    }
    /*顺子本身的规律：
    * 1.除0外其他数字不能重复出现
    * 1.除0外其他数字最大值和最小值之差不能超过5
    * */

    public boolean isOrderInCard2(int[] numbers)
    {
        if (numbers == null || numbers.length != 5)
        {
            return false;
        }
        int jokers = 0;/*0的数目*/
        Arrays.sort(numbers);
        for (int i = 0; i < 4; i++)
        {
            if (numbers[i] == 0) {
                jokers++;
            }
        }
        for (int j = numbers.length-1; j > jokers;j--)
        {
            if (numbers[j] == numbers[j-1]) return false;
        }
        if (numbers[numbers.length-1]-numbers[jokers]>=5)
        {
            return false;
        }
        return true;
    }
    /*不用排序的方法*/
    public boolean isOrderInCard3(int[] numbers)
    {
        if (numbers == null || numbers.length != 5) return false;
        int counts[] = new int[14];/*存储0~13的出现次数*/
        int max = -1;
        int min = 14;
        for (int i = 0; i < numbers.length;i++)
        {
            counts[numbers[i]]++;
            if (numbers[i] != 0)
            {
                if (counts[numbers[i]] > 1) return false;
                if (numbers[i] > max) max = numbers[i];
                if (numbers[i] < min) min = numbers[i];
            }
        }
        return max-min<5;
    }
}
