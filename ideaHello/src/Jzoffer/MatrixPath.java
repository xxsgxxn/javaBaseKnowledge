package Jzoffer;

public class MatrixPath {
    private static boolean hasPathTo(char[]matrix,int rows,int cols,int row,int col,char[] str,int len,boolean[] marked)
    {
        int index = row * cols + col;/*当前正在被比较字符的索引*/
        if (row < 0 || row >= rows || col < 0 || col >= cols || matrix[index] != str[len] || marked[index] == true)
        {
            return false;
        }
        if (len == str.length - 1)
        {
            return true;
        }
        marked[index] = true;

        if (hasPathTo(matrix,rows,cols,row,col-1,str,len+1,marked)||
        hasPathTo(matrix,rows,cols,row-1,col,str,len+1,marked)||
        hasPathTo(matrix,rows,cols,row,col+1,str,len+1,marked)||
        hasPathTo(matrix,rows,cols,row+1,col,str,len+1,marked))
        {
            return true;
        }
        /*匹配失败，重新放回，便于后续节点进行重新选择*/
        marked[index] = false;
        return false;
    }
    public static boolean hasPath(char[] matrix,int rows,int cols,char[] str)
    {
        if (matrix == null || rows <= 0 || cols <= 0 || str == null)
        {
            return false;
        }
        boolean[] marked = new boolean[matrix.length];
        for (int i = 0;i < rows;i++)
        {
            for (int j = 0;j < cols;j++)
            {
                if (hasPathTo(matrix,rows,cols,i,j,str,0,marked))
                {
                    return true;
                }

            }
        }
        return false;

    }
    private static int moveArea(int rows,int cols,int threshold)
    {
        if (rows <= 0 || cols <= 0)
        {
            return 0;
        }
        boolean []marked = new boolean[rows*cols];
        return countBlank(0,0,rows,cols,threshold,marked);

    }
    public static int countBlank(int row,int col,int rows,int cols,int threshold,boolean[] marked)
    {
        int count = 0;
        if (checked(row,col,rows,cols,threshold,marked))
        {
            marked[row*cols+col] = true;
            count = countBlank(row,col-1,rows,cols,threshold,marked) +
                    countBlank(row-1,col,rows,cols,threshold,marked) +
                    countBlank(row,col+1,rows,cols,threshold,marked) +
                    countBlank(row+1,col,rows,cols,threshold,marked) + 1;
        }
        return count;
    }
    private static boolean checked(int row,int col,int rows,int cols,int threshold,boolean[] marked)
    {
        if (row < 0 || row >= rows || col < 0 || col >= cols || digitSum(row)+digitSum(col) > threshold || marked[row*cols+col])
        {
            return false;
        }
        return true;
    }
    private static int digitSum(int n)
    {
        int sum = 0;
        while (n > 0)
        {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }



    public static void main(String[] args)
    {
        char[] matrix = {'a','b','t','g','c','f','c','h','j','d','e','h'};
        char[] str = {'b','f','c','e'};
        System.out.println(hasPath(matrix,3,4,str));

        int m = 3,n = 4;
        int thres = 3;
        System.out.println("机器人的运动范围:"+moveArea(3,4,thres));
    }

}
