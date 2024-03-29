class Solution {
    public int f(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos){
        int sum = 0;
        int len = price.size();
        for(int i=0; i<len; i++){
            sum += needs.get(i)*price.get(i);
        }
        for(int i=pos; i<special.size(); i++){
            List<Integer> list = special.get(i);
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<needs.size(); j++){
                if(needs.get(j) < list.get(j)){
                    temp = null;
                    break;
                }
                temp.add(needs.get(j)-list.get(j));
            }
            if(temp != null){
                sum = Math.min(sum, list.get(list.size()-1)+f(price, special, temp, i));
            }
        }
        return sum;
    }
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return f(price, special, needs, 0);
    }
}