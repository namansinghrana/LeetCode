class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROW=matrix.length,COL=matrix[0].length;
        int  l =0, r = ROW*COL-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            int row = mid / COL, col = mid % COL;
            if(target > matrix[row][col]){
                l  = mid+1;
            }else if(target < matrix[row][col]){
                r = mid-1;
            }else{
                return true;
            }
        }
        return false;
    }
}

//Another one
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<n;i++){
            if(matrix[i][0] <= target && target <= matrix[i][m-1]){
                int left=0, right = m-1;
                while(left <= right){
                    int mid = left + (right-left)/2;
                    if(matrix[i][mid] == target){
                        return true;
                    }else if(matrix[i][mid] > target){
                        right = mid-1;
                    }else{
                        left = mid+1;
                    }
                }
            }
        }
        return false;
    }
}
