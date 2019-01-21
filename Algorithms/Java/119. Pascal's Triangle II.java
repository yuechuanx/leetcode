class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new LinkedList<>();
        long num = 1;
        int tem = 1;
        for(int i = 0 ; i <= rowIndex; i++){
            result.add(tem);
            num = num * (rowIndex-i) / (i + 1);
            tem=(int)num;
        }
        
        return result;
    }
}