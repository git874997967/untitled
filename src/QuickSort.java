import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
            int[] x={9,2,4,7,3,7,10};
        System.out.println("array before sort" + Arrays.toString(x));
        int low=0;int high=x.length-1;
        quickSort3(x,low,high);
        System.out.println("array after sort"+ Arrays.toString(x));
    }
    public static void quickSort(int[] arr,int low,int high){
        if(arr.length==0||arr==null){
            return;
        }
        if(low>=high){
            return ;
        }
        int mid=low+(high-low)/2;
        int piv=arr[mid];
        int i=low;
        int j=high;
        while(i<=j){

            while(arr[i]<piv){
                i++;
            }
            while (arr[j]>piv){
                j--;
            }
            if(i<=j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
            if(low<j){
                quickSort(arr,low,j);
            }
            if(high>i) {
                quickSort(arr, i, high);
            }
        }
    }
    public static void quickSort1(int[] arr,int low, int high){
        if(arr.length==0||arr==null){
            return;
        }
        if(low>high ){
            return;
        }
        /* here we begin */
        int i=low; int j=high;
        int mid= low+(high-low)/2;
        int piv=arr[mid];
        while(i<=j){
            if(arr[i]<piv){
                i++;
            }
            if(arr[j]>piv){
                j--;
            }
            if(i<=j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                /* the two parts always forget take care*/
                i++;j--;
            }
            if(low<=j){
                quickSort(arr,low,j);
            }
            if(i<high){
                quickSort(arr,i,high);
            }
        }
    }
    public static void quickSort2(int [] arr, int low, int high){
                if(arr.length==0||arr==null){
                    return;
                }
                if(low>high){
                    return;
                }
                /*before the loop prepare the index*/
                int i=low;int j=high;
                int mid=low+(high-low)/2;
                int piv=arr[mid];
                while (i<=j){
                    /*normal part move the index only not change the elements*/
                    while(arr[i]<piv){
                        i++;
                    }
                    while(arr[j]>piv){
                        j--;
                    }
                    /* unnormal parts both change the indexs and elements*/
                    if(i<=j){
                        int temp=arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp;
                        i++;
                        j--;
                    }
                }
                    /*combine two sub arrays*/
                    if(low<j){
                        quickSort(arr,low,j);
                    }
                    if(i<high){
                        quickSort(arr,i,high);
                    }
    }
    public static void quickSort3(int[] arr,int low,int high){
        if(arr==null||arr.length==0)
        {
            return ;
        }
        if(low>=high){
            return;
        }
        /*prepare*/
        int i=low;int j=high;
        int mid=low+(high-low)/2;
        int piv=arr[mid];
        while(i<=j){
            while(arr[i]<piv){
                i++;
            }
            while(arr[j]>piv){
                j--;
            }
            if(i<=j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
            /*combin two arrays*/
            if(low<j) {
                quickSort3(arr,low,j);
            }
            if(high>i){
                quickSort3(arr,i,high);
            }
        }
    }
}
