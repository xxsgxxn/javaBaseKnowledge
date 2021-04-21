package Jzoffer;

public class ReverseLogrithmInArr {
    /*求数组中逆序对的个数，采用归并排序的办法*/
    public int findReverseLogrithmInArr(int[] arr)
    {
        if (arr == null || arr.length == 0)
        {
            return 0;
        }
        int [] aux = new int[arr.length];
        return sort(arr,aux,0,arr.length - 1);
    }
    public int sort(int[] arr,int[] aux,int low,int high)
    {
        if (high <= low) return 0;
        int mid = low + (high - low)/2;
        int left = sort(arr,aux,low,mid);/*左子数组中的逆序对*/
        int right = sort(arr,aux,mid+1,high);/*右子树中的*/
        int merged = merge(arr,aux,low,high,mid);
        return left + right + merged;
    }
    public int merge(int[]arr,int[] aux,int low,int high,int mid)
    {
        for (int k = low;k <= high;k++)
        {
            aux[k] = arr[k];
        }
        int count = 0;
        int i = mid;
        int j = high;
        int len = (high - low) / 2;
        for (int k = high;k >= low;k--)
        {
            if (i < low) arr[k--] = aux[j--];
            else if(j < mid + 1) {arr[k--] = aux[j--];
            }
            else if(aux[i] > aux[j]){
                count += j - low - len;
                arr[k--] = aux[i--];
        }else{
                arr[k--] = aux[j--];
            }
        }
        return count;
    }
}
