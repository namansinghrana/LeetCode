class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i= n-2;

        while(i >=0 && nums[i] >= nums[i+1]){
            i--;
        }

        if(i >= 0){
            int j=n-1;
            while(nums[j] <= nums[i]){
                j--;
            }
            swap(nums,i,j);
        }

        reverse(nums, i+1, n-1);
    }


    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums,int start,int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}


//Latest 2026 Code written by me without any help.
class Solution {
    public void nextPermutation(int[] nums) {

        int n = nums.length;
        //finding the breakpoint
        int idx = -1;
        for(int i=n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }

        //if index not changes
        if(idx != -1){
            //fixing the ending rythm
            for(int i=n-1;i>=0;i--){
                if(nums[i] > nums[idx]){
                    int temp = nums[i];
                    nums[i] = nums[idx];
                    nums[idx] = temp;
                    break;
                }
            }

            reverse(nums, idx+1, n-1);
        }else{
            //if index changes
            reverse(nums, 0, n-1);

        }
    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
