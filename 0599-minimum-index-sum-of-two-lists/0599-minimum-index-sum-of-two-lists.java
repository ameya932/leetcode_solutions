class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> hp = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0; i<list1.length; i++){
            hp.put(list1[i], i);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<list2.length; i++){
            String s = list2[i];
            if(hp.containsKey(s)){
                int a = hp.get(s);
                if(a+i < ans){
                    arr.clear();
                    arr.add(s);
                    ans = a+i;
                }
                else if(a+i == ans){
                    arr.add(s);
                }
            }
        }
        String s[] = new String[arr.size()];
        for(int i=0; i<arr.size(); i++){
            s[i] = arr.get(i);
        }
        return s;
    }
}