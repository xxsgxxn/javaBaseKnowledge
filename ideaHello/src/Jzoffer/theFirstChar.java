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


}
