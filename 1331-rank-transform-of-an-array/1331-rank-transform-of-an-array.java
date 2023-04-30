class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for(int i=0; i<sorted.length; i++){
            if(!rankMap.containsKey(sorted[i])){
                rankMap.put(sorted[i], rank);
                rank++;
            }
        }
        int[] result = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            result[i] = rankMap.get(arr[i]);
        }
        return result;
    }
}