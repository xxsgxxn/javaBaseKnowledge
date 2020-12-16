package Jzoffer;

import java.util.ArrayList;

public class PrintMatrix {
    public ArrayList<Integer> printMatix(int[][] arr)
    {
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0,right = arr[0].length - 1,top = 0,bottom = arr.length - 1;
        while (left <= right && top <= bottom)
        {
            /*1行*/
            for (int col = left;col <= right;col++)
            {
                res.add(arr[top][col]);
            }
            /*2行*/
            if (top < bottom)
            {
                for (int row = top + 1;row <= bottom;row++)
                {
                    res.add(arr[row][right]);
                }
            }
            /*2行2列至少*/
            if (top < bottom && left < right)
            {
                for (int col = right-1;col >= left;col++)
                {
                    res.add(arr[bottom][col]);
                }
            }
            /*3行2列*/
            if (top < bottom - 1 && left < right)
            {
                for (int row = bottom - 1;row > top;row--)
                {
                    res.add(arr[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
