class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        f(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }
    public void f(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int ind) {
        if (target > 0) {
            for (int i = ind; i<candidates.length; i++){
                cur.add(candidates[i]);
                f(result, cur, candidates, target-candidates[i], i);
                cur.remove(cur.size()-1);
            }
        }
        if (target == 0){
            result.add(new ArrayList<Integer>(cur));
        }
    }
}