class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }
    private static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot);
            quickSort(arr, pivot+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i=low-1, j=high+1;

        while(true){
            do{ i++; }while(arr[i] < pivot);
            do{ j--; }while(arr[j] > pivot);
            if(i >= j) return j;

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}