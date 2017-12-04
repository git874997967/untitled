import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args){
        int arr[]={12,11,13,5,7,4};
        System.out.println("before sort"+ Arrays.toString(arr));

       sort(arr,0,arr.length-1);
        System.out.println("after sort"+ Arrays.toString(arr));

    }
    public static void merge(int[] arr,int low, int mid, int high){
        /*find the size of two subarrays to be merged*/
        int n1=mid-low+1;
        int n2=high-mid;

        /*create temp arrays*/
        int L[]=new int[n1];
        int R[]=new int[n2];
        for(int i=0;i<n1;++i)
        {
            L[i]=arr[low+i];
        }

        for(int j=0;j<n2;++j){
            R[j]=arr[mid+1+j];
        }
       // System.out.println(Arrays.toString(R));
        /*merge the temp arrays*/
        int i=0;int j=0;
        /*init the index of merge subarray*/
        int k=low;
        while(i<n1&&j<n2){
            if(L[i]<=R[j]){
                arr[k]=L[i];
                i++;
            }
            else{
                arr[k]=R[j];
                j++;
            }
            k++;
        }
        /*copy remaining elemernts of L if any*/
        while(i<n1){
            arr[k]=L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=R[j];
            j++;
            k++;
        }

    }

    /* main function that sorts arr using merge*/
     public static void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}

