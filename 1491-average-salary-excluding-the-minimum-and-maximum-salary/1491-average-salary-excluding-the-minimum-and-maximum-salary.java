class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double total = 0;
        for(int i=0; i<salary.length; i++){
            if(salary[i]<min){
                min = salary[i];
            }
            if(salary[i]>max){
                max = salary[i];
            }
            total += salary[i];
        }
        total -= min+max;
        return total/(salary.length-2);
    }
}