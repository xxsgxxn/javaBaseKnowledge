package Jzoffer;

public class ReverseStr {
    /*I am a good student
     * 转成student good am I*/
    public String reverseStr1(String str)/*只适合有一个空格的*/ {
        if (str == null || str.length() <= 1) {
            return str;
        }
        char[] c = str.toCharArray();
        /*先整体反转，在遇到空格局部反转*/
        int low = 0;
        int high = str.length() - 1;
        while (low < high) {
            char tmp = c[low];
            c[low] = c[high];
            c[high] = tmp;
            low++;
            high--;
        }

        low = 0;
        while (low < str.length()) {
            if (c[low] == ' ') {
                low++;
            } else {
                int start = low;
                int end = low;
                while (end < str.length() - 1 && c[end + 1] != ' ') {
                    end++;
                }
                low = end + 2;
                while (start < end) {
                    char tmp = c[start];
                    c[start] = c[end];
                    c[end] = tmp;
                    start++;
                    end--;
                }
            }

        }
        return new String(c);
    }
    /*左旋字符串，abcdef,2，左旋cdefab，方法，先局部反转，ba fedc   ,再整体反转 cdef ab*/
    public String reverseStrLeft(String str,int len)
    {
        if (str == null || str.length() == 0 || len > str.length() || len < 0) return null;
        char[] c = str.toCharArray();
        reverse(c,0,len  - 1);
        reverse(c,len,str.length() - 1);
        reverse(c,0,str.length()-1);
        return new String(c);

    }
    public void reverse(char[] c,int low,int high)
    {
        while (low < high)
        {
            char tmp = c[low];
            c[low] = c[high];
            c[high] = tmp;
            low++;
            high--;
        }
    }
}




