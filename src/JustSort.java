public class JustSort {
    /**
     * Bubble sort
     *
     * @param arr array wait to be sorted
     */

    public static int[] BubbleSort(int[] arr) {
        int length = arr.length;
        int temp = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    Swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    public static int[] cocatailSort(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    Swap(arr, i, i + 1);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    Swap(arr, i - 1, i);
                }
            }
            left++;

        }
        return arr;
    }

    public static int[] SelectionSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            // 第几次遍历   从最小值开始  开始更新最小值
            int min = i;
            for (int j = i + 1; j < length; j++) {
                // 遍历规程中 发现最小值  进行标记
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            //如果 最小值 和 最小角标对应不上   则把当前最小值更新
            if (min != i) {
                Swap(arr, min, i);
            }
        }
        return arr;
    }

    public static int[] InsertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //排好序的最后一个元素值
            int get = arr[i];
            // j 之前的数组默认排好序
            int j = i - 1;
            // 将数组 向后移动 空出位置
            while (j >= 0 && arr[j] > get) {
                arr[j + 1] = arr[j];
                j--;
            }
            // 更新之前排好序的数组   最后一个编程  j-1
            arr[j + 1] = get;
        }
        return arr;
    }

    public static int[] ShellSort(int[] arr) {
        int h = 0;
        while (h < arr.length) {
            //生成步长
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < arr.length; i++) {
                int j = i - h;
                int get = arr[i];
                while (j >= 0 && arr[j] > get) {
                    arr[j + h] = arr[j];
                    j = j - h;
                }
                arr[j + h] = get;
            }
            h = (h - 1) / 3;   // 递减增量
        }
        return arr;
    }

    public static int[] MergeSortIteration(int[] arr){
        int left,mid,right;
        for(int i=1;i<arr.length;i=i*2){
            left=0;
            while(left+i<arr.length){
                mid=left+i-1;
                right=mid+i<arr.length?mid+i:arr.length-1;
                Merge(arr,left,mid,right);
                left=right+1;
            }
        }
        return  arr;
    }
    public  static  int[] Merge(int[]arr,int left,int mid,int right){
        int len=right-left+1;
        int [] temp=new int[len];
        int index=0;
        int i=left;
        int j=mid+1;
        while(i<=mid&&j<=right){
            temp[index++]=arr[i]<arr[j]?arr[i++]:arr[j++];
        }
        while(i<=mid){
            temp[index++]=arr[i++];
        }
        while(j<=right){
            temp[index++]=arr[j++];
        }
        for(int k=0;k<len;k++){
            arr[left++]=temp[k];
        }
        return arr;
    }

    public static int[] quickSort(int[] arr,int low,int high){
        if(arr.length==0){
            return null;
        }
        if(low>=high){
            return null;
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
        return  arr;
    }


    public static void main(String[] args) {
        int[] test = {1, 5, 2, 4, 6, 9, 8, 3, 7};
        //BubbleSort(test);
        //cocatailSort(test);
        //SelectionSort(test);
        // InsertSort(test);
      //  ShellSort(test);
      //  MergeSortIteration(test);
     //   quickSort(test,0,test.length-1);
        HeapSort(test);
        Print(test);
    }
public  static  int BuildHeap(int[] arr){
        int heapSize=arr.length;
        for(int i=heapSize/2-1;i>0;i--){
            Heapify(arr,i,heapSize);
        }
        return  heapSize;
}
public static int[] Heapify(int[]arr,int i,int size){
        int lc=2*i+1;
        int rc=2*i+2;
        int max=i;
        if(lc<size&&arr[lc]>arr[max])
            max=lc;
        if(rc<size&&arr[rc]>arr[max])
            max=rc;
        if(max!=i){
            Swap(arr,i,max);
            Heapify(arr,max,size);
        }
        return arr;
}

public static int[] HeapSort(int[] arr){
        int heapSize=BuildHeap(arr);
        while(heapSize>1){
            Swap(arr,0,--heapSize);
            Heapify(arr,0,heapSize);
        }
        return arr;
}

    // util function
    public static void Swap(int arr[], int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    // print value
    public static void Print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
