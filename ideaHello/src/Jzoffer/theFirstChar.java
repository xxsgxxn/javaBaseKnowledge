package Jzoffer;

public class theFirstChar {
    /*找出第一次只出现一次的字符，按位异或(是数组中出现一次的方法)，这个是按hash表值来决定的？*/
    public char findOneChar(String str) /*要是返回索引在返回处返回i值就可*/
    {
        if (str == null || str.length() == 1)
        {
            return '\0';
        }
        int count[] = new int[256];
        for (int i = 0;i < str.length();i++)
        {
            count[str.charAt(i)]++;//统计每个字符出现次数
        }
        for (int i = 0;i < str.length();i++)
        {
            if (count[str.charAt(i)] == 1)
            {
                return str.charAt(i);
            }
        }
        return '\0';
    }
    /*扩展，剔除str1中在str2中有的字符*/
    public String deleteCharInStr2(String str1,String str2)
    {
        if (str2 == null || str2.length() == 0)
        {
            return str1;
        }
        StringBuilder str = new StringBuilder();
        int [] count = new int[256];
        for (int i = 0;i < str2.length(); i++)
        {
            count[str2.charAt(i)]++;
        }
        for(int i = 0;i < str1.charAt(i);i++)
        {
            if (count[str1.charAt(i)] == 0)
            {
                str.append(str1.charAt(i));
            }
        }
        return str.toString();
    }

    /*删除一个字符串中重复的字符*/
    public String deleteReplicate(String str)
    {
        if (str == null || str.length() == 0)
        {
            return str;
        }
        boolean occur[] = new boolean[256];
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < str.length();i++)
        {
            if (!occur[str.charAt(i)])
            {
                sb.append(str.charAt(i));
            }
            occur[str.charAt(i)] = true;
        }
        return sb.toString();
    }

    /*变位词，两个字符串出现的字符一样且出现次数相同，为变位词*/
    public boolean isChangeStr(String str1,String str2)
    {
        if (str1 == null || str2 == null)
        {
            return false;
        }
        int count[] = new int[256];
        for (int i = 0;i < str1.length();i++)
        {
            count[str1.charAt(i)]++;
        }
        for (int i = 0; i < str2.length();i++)
        {
            count[str2.charAt(i)]--;
        }
        for (int i = 0;i < 256;i++)
        {
            if (count[i] != 0)
            {
                return false;
            }
        }
        return true;
    }
}
