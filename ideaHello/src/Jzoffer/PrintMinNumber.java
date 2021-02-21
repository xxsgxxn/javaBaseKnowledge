package Jzoffer;

import java.util.ArrayList;

public class PrintMinNumber {
    /*根据输入的数组使得拼接出的数最小nm>mn就让m在n的前面*
    */
    public String outputMinNumber(int[] arr)
    {
        if (arr == null || arr.length == 0) return "";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0;i < arr.length;i++)
        {
            list.add(arr[i]);
        }
        list.sort((a,b)->(a+""+b).compareTo(b+""+a));
        StringBuilder sb = new StringBuilder();
        for (int a:list)
        {
            sb.append(a);
        }
        return sb.toString();
    }

}
