class Solution {
    public double average(int[] salary) {
        double min=Integer.MAX_VALUE;
        double max=Integer.MIN_VALUE;


        for(int i=0;i<salary.length; i++){
            min = Math.min(min , salary[i]);
        }
        for(int i=0;i<salary.length; i++){
            max = Math.max(max , salary[i]);
        }

        double sum=0;
        for(int i=0;i<salary.length; i++){
            if(salary[i] == min || salary[i] == max){
                continue;
            }else{
                sum = sum + salary[i];
            }
        }
        return sum/(salary.length-2);
    }
}