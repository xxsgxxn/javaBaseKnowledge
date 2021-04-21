package Jzoffer;

public class FirstAppreanceChar {
    private int index;/*记录字符串的索引*/
    private int[] count;
    public FirstAppreanceChar()
    {
        index = 0;
        count = new int[256];
        for (int i = 0; i < count.length; i++)
        {
            count[i] = -1;/*-1表示未出现过*/
        }
    }
    public void insert(char c)/*模拟插入函数*/
    {
        if (count[c] == -1) count[c] = index;
        else if (count[c] >= 0) count[c] = -2;/*第二次出现了*/
        index++;
    }

    public char findFirstAppreanceChar()
    {
        int minIndex = Integer.MAX_VALUE;
        char c = '\0';
        for (int i = 0;i < 256;i++)
        {
            if (count[i] >= 0 && count[i] < minIndex)
            {
                minIndex = count[i];
                c = (char) i;
            }
        }
        return c;
    }
    public static void main(String[] args)
    {
        FirstAppreanceChar f = new FirstAppreanceChar();
        f.insert('g');
        System.out.println(f.findFirstAppreanceChar());
        f.insert('o');
        System.out.println(f.findFirstAppreanceChar());
        f.insert('o');
        System.out.println(f.findFirstAppreanceChar());
        f.insert('g');
        System.out.println(f.findFirstAppreanceChar());
        f.insert('l');
        System.out.println(f.findFirstAppreanceChar());
        f.insert('e');
        System.out.println(f.findFirstAppreanceChar());
    }
}
