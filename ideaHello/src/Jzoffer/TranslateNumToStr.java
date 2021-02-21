package Jzoffer;

import java.util.ArrayList;
import java.util.List;

public class TranslateNumToStr {
    /*0->a   1->b*/
    public List<String> translateNum(int n) {
        List<String> res = new ArrayList<>();
        if (n < 0) return res;
        String str = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        translate(str,sb,res);
        return res;

    }

    private void translate(String str, StringBuilder sb, List<String> res) {
        if (str.equals("")) {
            res.add(sb.toString());
            return;
        }
        /*一次就翻译一个数*
         */
        String sub = str.substring(0, 1);
        char num = (char) (Integer.parseInt(sub) + 97);
        sb.append(num);
        translate(str.substring(1),sb,res);
        sb.deleteCharAt(sb.length()-1);
        if (str.length() >= 2)
        {
            String sub2 = str.substring(0,2);
            if (checkNum(sub2))
            {
                char num2 = (char) (Integer.parseInt(sub2) + 97);
                sb.append(num2);
                translate(str.substring(2),sb,res);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    private boolean checkNum(String num)
    {
        int val = Integer.parseInt(num);
        return val >= 10 && val <= 25;
    }

    /*第二种方法是从右往左的循环，相当于青蛙跳台阶了，只是跳二阶的时候有条件*/
    public int translateNum2(int num)
    {
        if (num < 0) return 0;
        String str = String.valueOf(num);
        return countTranslate(str);

    }
    private int countTranslate(String str)
    {
        int len = str.length();
        int[] count = new int[len];
        count[len - 1] = 1;
        for (int i = len -2; i >= 0;i--)
        {
            int digitTen = str.charAt(i) - '0';
            int digitOne = str.charAt(i+1) - '0';
            int digit = digitTen*10 + digitOne;
            if (digit>=10 && digit<=25)
            {
                if (i == len-2){
                    count[i] = count[i+1] + 1;
                }else{
                    count[i] = count[i+1] + count[i+2];
                }
            }else{
                count[i] = count[i+1];
            }
        }
        return count[0];
    }

    public static void main(String[] args)
    {
        int num = 12258;
        TranslateNumToStr tl = new TranslateNumToStr();
        System.out.println("left->right:"+tl.translateNum(num).size());
        System.out.println("right->left:"+tl.translateNum2(num));
    }
}
