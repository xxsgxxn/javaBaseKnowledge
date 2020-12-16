package Jzoffer;

public class RevolveArr {
    int minRevolveArrEle(int [] arr)
    {
         if (arr.length == 0)
         {
             return 0;
         }
         int index = arr.length - 1;
         for (int i = 0;i<arr.length-1;i++)
         {
             if (arr[i] > arr[i+1])
             {
                index =  i;
                break;
             }
         }
         return arr[index+1];
    }
    int minRevolveArrMid(int[] arr)
    {
        if (arr.length == 0)
        {
            return 0;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low < high)
        {
            int mid = low + (high-low)/2;
            if(arr[mid] > arr[high])
            {
                low = mid + 1;
            }else if (arr[mid] < arr[high])
            {
                high = mid;
            }else{
                high--;
            }
        }
        return arr[low];

    }
    public static void main(String[] args)
    {
        RevolveArr test = new RevolveArr();
        int[] a = {3,4,5,1,2};
        System.out.println(test.minRevolveArrEle(a));
        System.out.println(test.minRevolveArrMid(a));
    }
}
