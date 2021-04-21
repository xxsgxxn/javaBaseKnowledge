package Jzoffer;

public class TransStrToInt {
    /*将一个字符串转化为整数-34  78 非法字符串返回0*/
    private boolean valid;
    public int transStrToInt(String str)
    {
        valid = false;
        if (str == null || str.length() == 0) return 0;
        boolean negative = false;/*复数的标志*/
        int num = 0;
        int flag = 1;
        for (int i = 0; i < str.length(); i++)
        {
            if (i == 0 && (str.charAt(i) == '+' || str.charAt(i) == '-'))
            {
                if (str.charAt(i) == '-')
                {
                    negative = true;
                    flag = -1;
                }
                if (str.length() == 1)
                {
                    return 0;
                }
                continue;/*跳过第一位+-号*/
            }
            if (str.charAt(i) < '0' || str.charAt(i) > '9')
            {
                return 0;
            }
            num += num * 10 + str.charAt(i) - '0';
        }
        num = flag * num;
        if (!negative && num > Integer.MAX_VALUE || negative && num < Integer.MIN_VALUE)
        {
            return 0;
        }
        valid = true;
        return num;
    }
}
