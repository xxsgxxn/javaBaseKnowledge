package Jzoffer;

public class NDicePoints {
    /*n个骰子的点数，递归*/
    public void printPoints(int n)
    {
        if (n <= 0)
        {
            return;
        }
        printNpoints(n,0);
    }
    public void printNpoints(int n,int sum)
    {
        if (n==0)
        {
            System.out.println(sum+" ");
            return;
        }
        printNpoints(n-1,sum+1);
        printNpoints(n-1,sum+2);
        printNpoints(n-1,sum+3);
        printNpoints(n-1,sum+4);
        printNpoints(n-1,sum+5);
        printNpoints(n-1,sum+6);
    }
    /*求点数和的概率的话，就是1：1~6 2：2~12 3：3~18 n:n~6n 用6n-n+1的数组存储点数和和其概率 0：n的概率 6n-
    * 下标6n-n就是6n的概率，所有点数和出现的情况共有6^n,用各个和出现次数来进行除以6^n就可*/
    private int sideNum = 6;
    public void printProbabilities(int n)
    {
        if (n < 1) return;
        int maxval = sideNum * n;
        int totals = (int)Math.pow(sideNum,n);
        int probabilities[] = new int[sideNum*n - n + 1];
        getProbabilities(n,n,0,probabilities);
        for (int i = n;i <= maxval;i++)
        {
            System.out.println("s="+i+":"+probabilities[i-n]+"/"+totals);
        }

    }
    public void getProbabilities(int n,int cur,int sum,int[] probabilities)
    {
        if (cur == 0)
        {
            probabilities[sum-n]++;
            return;

        }
        for (int i = 1;i <= sideNum;i++)
        {
            getProbabilities(n,cur-1,sum+i,probabilities);
        }
    }
    public static void main(String srgs[])
    {
        NDicePoints point = new NDicePoints();
        point.SpacePrintProbabalities(2);

    }

    /*采用动态规划的方法进行，f(n,sum)的出现次数就相当于sum(f(n-1,sum-i) 1<=i<=6,sum > i)*/
    public void printprobalities(int n)
    {
        if (n < 1)
        {
            return;
        }
        int maxval = sideNum * n;
        int p[][] = new int[n+1][maxval+1];
        //初始化
        for (int i = 1;i <= sideNum;i++)
        {
            p[1][i] = 1;
        }
        /*逐渐增加筛子个数*/
        for (int k = 2;k <= n;k++)
        {
            for (int sum = k;sum <= sideNum*k;sum++)
            {
                for (int i = 1;sum > i&&i <= sideNum;i++)
                {
                    p[k][sum] += p[k-1][sum-i];
                }

            }

        }
        int total = (int) Math.pow(sideNum,n);
        for (int i = n;i <= maxval;i++)
        {
            System.out.println("s="+i+":"+p[n][i]+"/"+total);
        }
    }
    /*更省空间的动态规划*/
    public void SpacePrintProbabalities(int n)
    {
        if (n < 1)
        {
            return;
        }
        int maxval = sideNum * n;
        int probalities[][] = new int[2][maxval + 1];
        int flag = 0;
        for (int i = 1; i <= sideNum;i++)
        {
            probalities[flag][i] = 1;
        }
        for (int k = 2; k <= n; k++)
        {
            for (int sum=k;sum <= sideNum * k;sum++)
            {
                int s = 0;
                for (int i = 1; i <= sideNum&&i<sum;i++)
                {
                    s += probalities[flag][sum-i];
                }
                probalities[1-flag][sum] = s;
            }
            flag = 1 - flag;
        }
        int total = (int)Math.pow(sideNum,n);
        for (int i = n;i <= sideNum*n;i++)
        {
            System.out.println("s="+i+":"+probalities[flag][i]+"/"+total);
        }
    }


}
