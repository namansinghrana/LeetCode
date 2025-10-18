class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] cover = new int[52];
        int n = ranges.length;
        

        //Creating a table that keep complete list of ranges we touched.
        for(int[] range : ranges){
            cover[range[0]] += 1;
            cover[range[1]+1] -= 1;
        }

        ///prefix Sum of the ranges we touched upto current range.
        for(int i=1; i<=cover.length-1;i++) cover[i] += cover[i-1];

        //checking if any of the left to right range has not touched
        //any of the count ranges.
        for(int i=left; i<=right; i++) {if(cover[i] == 0) return false;}
        return true;
    }
}
