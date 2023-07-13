class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int card : hand){
            count.put(card, count.getOrDefault(card, 0)+1);
        }
        Arrays.sort(hand);
        for(int i=0; i<hand.length; i++){
            if(count.get(hand[i]) == 0){
                continue;
            }
            for(int j=0; j<groupSize; j++){
                int curr = hand[i]+j;
                if(count.getOrDefault(curr, 0) == 0){
                    return false;
                }
                count.put(curr, count.get(curr)-1);
            }
        }
        return true;
    }
}