package Jzoffer;

public class GainMutipleArr {
    /*给定a[n],求一个b[n],b[i] = a[0]*a[1]*...a[i-1]*a[i+1]*a[i+2]*...*a[n-1]*/
    public int[] gainMutipleArr(int a[])
    {
        if (a == null || a.length == 0) return null;
        int b[] = new int[a.length];
        b[0] =  1;/*c[i] = a[0]*...a[i-1]*/
        for (int i = 1;i < a.length;i++)
        {
            b[i] = b[i-1]*a[i-1];
        }
        /*求d[i] = a[i+1]*...*a[n-1],d[i]=d[i+1]*a[i+1]*/
        int d = 1;
        for (int j = a.length - 2;j >= 0;j--)
        {
            d *= a[j+1];
            b[j] *= d;
        }
        return b;
    }
}
