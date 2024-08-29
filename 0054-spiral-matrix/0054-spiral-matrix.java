class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int T = 0 , B = matrix.length-1;
        int L = 0 , R = matrix[0].length-1;
        int dir=0;
        List<Integer> ans = new ArrayList<>();

        while(T <= B && L <= R){
            if(dir == 0){
                for(int i=L; i<=R; i++){
                    ans.add(matrix[T][i]);
                }
                T++;
            }else if(dir == 1){
                for(int i=T; i<=B; i++){
                    ans.add(matrix[i][R]);
                }
                R--;
            }else if(dir == 2){
                for(int i=R; i>=L; i--){
                    ans.add(matrix[B][i]);
                }
                B--;
            }else if(dir == 3){
                for(int i=B;i>=T;i--){
                    ans.add(matrix[i][L]);
                }
                L++;
            }

            dir = (dir+1) % 4;
        }
        return ans;
    }
}