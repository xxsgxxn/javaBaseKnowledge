package Jzoffer;

public class PowXy {
    public static double power1(double base,int exponent)
    {
        if (base == 0)
        {
            return 0;
        }
        if (exponent == 0)
        {
            return 1.0;
        }
        double res = 1.0;
        int positiveExponent = Math.abs(exponent);
        while (positiveExponent != 0)
        {
            if ((positiveExponent&1) != 0)//jishu
            {
                res = res * base;
            }
            base *= base;
            positiveExponent = positiveExponent >> 1;
        }
        return exponent < 0 ? 1 / res : res;
    }
    private static double power2Recur(double base, int exponent)
    {
        if (exponent == 0)
        {
            return 1.0;
        }
        if (exponent == 1)
        {
            return base;
        }
        double res = power2Recur(base,exponent >> 1);
        res = res * res;
        if ((exponent & 1) != 0)
        {
            res *= base;
        }
        return res;
    }
    public static double power2(double base, int exponent)
    {
        if (base == 0)
        {
            return 0;
        }
        int positiveExponent = Math.abs(exponent);
        double res = power2Recur(base,positiveExponent);
        return exponent < 0 ? 1 / res : res;
    }
    public static void main(String[] args)
    {
        double base = 2.0;
        int exponent1 = 3;
        int exponent2 = -3;
        System.out.println(power1(base,exponent1)+"    "+power1(base,exponent2));
        System.out.println(power2(base,exponent1)+"    "+power2(base,exponent2));
    }
}
