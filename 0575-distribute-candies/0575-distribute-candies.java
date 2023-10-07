class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> type = new HashSet<>();
        int half = candyType.length/2;
        for (int c : candyType) {
            if (type.size() >= half)
                return half;
            type.add(c);
        }
        return Math.min(type.size(), half);
    }
}