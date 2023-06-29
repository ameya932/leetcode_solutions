class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k<=0 || n<=0){
            return result;
        }
        combinationSum(1, k, n, new ArrayList<>());
        return result;
    }
    public void combinationSum(int start, int k, int n, List<Integer> list){
        if(k==0 && n==0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(k==0 || n<0){
            return;
        }
        for(int i=start; i<=9; i++){
            list.add(i);
            combinationSum(i+1, k-1, n-i, list);
            list.remove(list.size()-1);
        }
    }
}