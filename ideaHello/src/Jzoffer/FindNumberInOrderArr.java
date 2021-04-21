package Jzoffer;
/*在排序数组中查找某个数字出现次数*/
public class FindNumberInOrderArr {
    /*普通遍历法*/
    int findNumberInArrOne(int[] arr,int key)
    {
        if (arr == null || arr.length == 0)
        {
            return -1;
        }
        boolean flag = false;
        int count = 0;
        for (int i = 0; i < arr.length;i++)
        {
            if (arr[i] == key && flag == false)/*第一次找到*/
            {
                count++;
                flag = true;
            }else if (arr[i] == key)/*之后每次找到*/
            {
                count++;
            }else if (arr[i] != key && flag == true){
                break;
            }
        }
        return count;

    }
    public int partation(int[] arr,int key) /*采用二分法查找索引，然后再在索引的附近找*/
    {
        int low = 0;
        int high = arr.length - 1;
        int mid = low + (high - low)/2;
        while (low <= high)
        {
            if (key > arr[mid])
            {
                 low = mid + 1;
            }else if (key < arr[mid])
            {
                 high = mid - 1;
            }else{
                return mid;
            }
            mid = low + (high - low)/2;
        }
        return -1;/*未找到*/
    }
    public int findNumberInArrTwo(int[] arr,int key)
    {
        if (arr == null || arr.length == 0)
        {
            return -1;
        }
        int index = partation(arr,key);
        int count = 1;
        for (int i = index-1; i >= 0;i--)
        {
            if (arr[i] != key)
            {
                break;
            }else{
                count++;
            }
        }
        for (int i = index + 1; i < arr.length;i++)
        {
            if (arr[i] != key)
            {
                break;
            }else{
                count++;
            }
        }
        return count;

    }
    /*在n-1的数组中查找缺失的那个数*/
    /*二分查找：
    * 1.如果arr[mid] == mid,mid之前的数未缺失，low = mid+1
    * 2.若arr[mid] != mid,看mid前一个数是否等于其索引，等于就返回mid
    * 不等于就继续遍历，high=mid-1*/
    public int findMissingNumber(int[] arr)
    {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high)
        {
            int mid = low + (high - low)/2;
            if (mid == arr[mid]){
                low = mid + 1;
            }else if (mid != arr[mid])
            {
                if (mid == 0 || mid - 1 == arr[mid - 1])
                {
                    return mid;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    /*找到数组中值和索引相等的元素,且数组是单调递增的*/
    /*二分查找*/
    public int indexEqualIndexData(int arr[])
    {
        if (arr == null || arr.length == 0)
        {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low <= high)
        {
            int mid = low + (high - low)/2;
            if (mid > arr[mid])
            {
                low = mid + 1;
            }else if(mid < arr[mid]) {
                high = mid - 1;
        }else{
                return mid;
            }
        }
        return -1;
    }

}
