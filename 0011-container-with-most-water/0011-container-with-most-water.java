class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right = height.length-1;

        int maxArea1=0;
        while(left < right){
            
            maxArea1 = Math.max(maxArea1 , (right-left) * Math.min(height[left],height[right]));
            
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }

        return maxArea1;
    }
}