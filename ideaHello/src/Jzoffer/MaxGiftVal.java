package Jzoffer;

public class MaxGiftVal {
    /*m*n的方格，ij最大的价值为左边（i，j-1）+ gift(i,j)和上边的最大价值（i-1，j）*/
    public int maxGiftValDp(int[] gifts,int rows,int cols)
    {
        if (gifts == null || gifts.length == 0) return 0;
        int[][] maxval = new int[rows][cols];
        for (int row = 0;row < rows;row++)
        {
            for (int col = 0;col < cols;col++)
            {
                int up = 0;
                int left = 0;
                if (row > 0) up = maxval[row-1][col];
                if (col > 0) left = maxval[row][col-1];
                maxval[row][col] = Math.max(up,left) + gifts[cols * row + col];
            }
        }
        return maxval[rows-1][cols-1];
    }

    /*优化完后是用一维数组替换二维*/
}
