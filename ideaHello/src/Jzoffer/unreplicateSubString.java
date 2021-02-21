package Jzoffer;

public class unreplicateSubString {
    public int longUnreplicateString(String str)
    {
        int curLen = 0;
        int maxLen = 0;
        /*当前字符str{i}没在str{i-1}之前的字符出现过，在str{i-1}结尾之前的字符出现过，就是f{i} = f{i-1}+1
        * 出现过，就f{i} = i - preindex(之前出现过的位置)*/
        int [] position = new int[26];
        for (int i = 0;i < 26;i++)
        {
            position[i] = -1;
        }
        for (int i = 0; i < str.length();i++)
        {
            int preindex = position[str.charAt(i) - 'a'];
            if (preindex == -1 || i - preindex > curLen) curLen++;/*没重复出现的*/
            else{
                /*先把长的最大字符串存储起来*/
                if (curLen > maxLen ) maxLen = curLen;
                curLen = i - preindex;
            }
            /*记录当前字符的位置*/
            position[str.charAt(i) - 'a'] = i;
        }
        if (curLen > maxLen ) maxLen = curLen;
        return maxLen;
    }

    /*还有一种方法是设置之前出现标志位pre，当新的字符出现查找其在pre和i之间有未出现，出现，则改变pre=j,长度变为curLen = i - j , */
    public int subStringLen(String str)
    {
        if (str.length() == 0 || str == null)
        {
            return 0;
        }
        int pre = 0;
        int maxLen = 1;
        int curLen = 1;
        for (int i = 1;i < str.length();i++)
        {
            for ( int j = i - 1;j >= pre;j++)
            {
                if (str.charAt(i) == str.charAt(j))
                {
                    maxLen = Math.max(curLen,maxLen);
                    curLen = i - j;
                    pre = j;
                    break;
                }else {
                    curLen++;
                }
            }
        }
        if (curLen > maxLen) maxLen = curLen;
        return maxLen;
    }
}
