package Jzoffer;

public class ReorderArray {
    public static void reorderArr1(int[] arr)
    {
        if (arr == null || arr.length == 0)
        {
            return;
        }
        int[] temp = new int[arr.length];
        int k = 0;
        for (int i = 0;i < arr.length;i++)
        {
            if ((arr[i]&1) == 1)
            {
                temp[k++] = arr[i];
            }
        }
        for (int i = 0;i < arr.length;i++)
        {
            if ((arr[i]&1) != 1)
            {
                temp[k++] = arr[i];
            }
        }
        for (int i = 0;i < arr.length;i++)
        {
            arr[i] = temp[i];
        }

    }
    public static void reorderArr2(int[] arr)
    {
        if (arr == null || arr.length == 0)
        {
            return;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low < high)
        {
            while (low < high && ((arr[low]&1) == 1))
            {
                low++;
            }
            while (low < high && ((arr[high]&1) != 1))
            {
                high--;
            }
            if (low < high)
            {
                arr[low] = arr[low] + arr[high];
                arr[high] = arr[low] - arr[high];
                arr[low] = arr[low] - arr[high];
            }
        }
    }
    public static void main(String[] args)
    {
        int[] arr1 = {1,2,1,2,1,2};
        reorderArr1(arr1);
        System.out.println(arr1.toString());
        for (int i = 0;i < arr1.length;i++)
        {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        int[] arr2 = {1,2,2,1,2,1};
        reorderArr2(arr2);
        for (int i = 0;i < arr1.length;i++)
        {
            System.out.print(arr2[i] + " ");
        }

    }
}
