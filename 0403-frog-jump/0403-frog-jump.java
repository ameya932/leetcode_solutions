class Solution {
    public boolean canCross(int[] stones) {
        if(stones[1]-stones[0] != 1){
            return false;
        }
        int stonesCount = stones.length;
        int stonesBase = stones[1];
        int stonesFarthest = (stonesCount*(stonesCount+1))/2;
        if(stones[stonesCount-1]-stonesBase > stonesFarthest){  
            return false;
        }
        stonesFarthest = Math.min(stonesFarthest, stones[stonesCount-1]-stonesBase+stonesCount);
        boolean[] stonesArr = new boolean[stonesFarthest+1];
        for(int i=stones.length-1; i>0; i--){
            stonesArr[stones[i]-stonesBase] = true;
        }
        return dfs(0, 1, stonesArr, new HashSet<Long>(), stones[stonesCount-1]-stonesBase);
    }
    private boolean dfs(int pos, int k, boolean[] stonesArr, HashSet<Long> failedSet, int lastStonePos) {
        if(pos == lastStonePos){
            return true;
        }
        if(failedSet.contains((long)pos*10_000+k)){
            return false;
        }
        if(stonesArr[pos+k+1]){
            if (dfs(pos+k+1, k+1, stonesArr, failedSet, lastStonePos)){
                return true;
            }
        }
        if (stonesArr[pos+k]){
            if (dfs(pos+k, k, stonesArr, failedSet, lastStonePos)){
                return true;
            }
        }
        if (k>1 && stonesArr[pos+k-1]){
            if (dfs(pos+k-1, k-1, stonesArr, failedSet, lastStonePos)){
                return true;
            }
        }
        failedSet.add((long)pos*10_000+k);
        return false;
    }
}