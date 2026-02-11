// Brute Force
// First we can create all the possible combinations and linear search on them for our next question.


// Optimal
// We can understand the ordering of our current permutation.
// Then we can search for our element that can change our entire permutation into the next permutation 
// this can be done by finding the number that is smaller then its next number that back to front ordering shows the numbers ordering from the one's place to upwards we can find our number that will change our trajectory.
// Now once we find that breakpoint we will remember it and try to find the just next larger numebr after it from the end again.
// Note  - You want to know what is the guarantee that we will find our exact next largest number fron the end don't you but we have once already iterated those numbers haven't we
// If there was such combination beforehand than, wouldn't it become the first breakpoint ?
// Anyways
// when we iterate from end upto the idx point once we find the first number which is greater than idx point whihc is obviously the smallest among the current iteration but greater than idx point. We swap.
// Now once we have actually figured out this swap we have founded our next possible permutation starter.
// Now to completely make it the next closest permutation we have to arrange the ramining numbers in ascending order so that makes upn our lowest possible permutation.

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
        int n= nums.length;
        int idx = -1;


        //Finding the breakpoint
        for(int i=n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }

        if(idx == -1){
            //when there is no break point it means it's the largest permutation
            //So it's next permutation is gonna be the smallest.
            reverse(nums, 0, n-1);
        }else{
            //When we found the breakpoint for permutation
            //we will now check for the next smallest element but greater than idx
            //that will create the next permutation initially.
            for(int i=n-1;i>=0;i--){
                if(nums[i] > nums[idx]){
                    int temp = nums[i]; /* */
                    nums[i] = nums[idx];  /* */ 
                    nums[idx] = temp;
                    break;
                }
            }

            //Once we found the next permutation initials 
            // we will create the smallest sequence of numbers afterwards to create the closest permutation.
            //reverse the remaining numbers in the list
            reverse(nums, idx+1, n-1);
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
