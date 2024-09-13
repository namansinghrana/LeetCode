class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0,k=0;
        int[] newArray = new int[m];

        for(int idx=0; idx<m; idx++){
            newArray[idx] = nums1[idx];
        }

        while(i < m && j < n && k < m+n){

            if(newArray[i] < nums2[j]){
                nums1[k] = newArray[i];
                i++;
                k++;
            }else{
                nums1[k] = nums2[j];
                k++;
                j++;
            }
        }
        while(i < m){
            nums1[k] = newArray[i];
            i++;
            k++;
        }
        while(j < n){
            nums1[k] = nums2[j];
            j++;
            k++;
        }
    }
}