package Jzoffer;

import java.util.LinkedList;

public class LastNumInCircle {
    /*0~n-1个数字中，从0开始每次出第m个数，求最后剩下的数字*/
    public int findlastNumberIncircle(int n,int m)
    {
        if (n <= 0 || n <= 0) return -1;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0;i < n;i++)
        {
            list.add(i);
        }
        int p = 0;
        while (list.size()>1)
        {
            int k = 0;
            while (k<m-1)
            {
                p++;
                k++;
                if (p == list.size()) p = 0;
            }
            /*删除p=m，*/
            list.remove(p);
            if (p == list.size()) p=0;
        }
        return list.get(0);
    }
    /*数学规律：约瑟夫环问题*/
    /*f(n,m)n个数中删除m个数后剩下的数，经推导f(n,m)=[f(n-1,m)+m]%n*/
    public int lastNUmberInCircle(int n,int m)
    {
        if (n <= 0 || m <= 0)
        {
            return -1;
        }
        int f = 0;
        for (int i = 2;i <= n; i++)
        {
            f = (f + m) % n;
        }
        return f;
    }


}
