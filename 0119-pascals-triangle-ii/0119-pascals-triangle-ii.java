class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for(int i=0; i<rowIndex; i++){
            List<Integer> curr = new ArrayList<Integer>();
            curr.add(1);
            for(int j=1; j<row.size(); j++){
                curr.add(row.get(j-1)+row.get(j));
            }
            curr.add(1);
            row = curr;
        }
        return row;
    }
}