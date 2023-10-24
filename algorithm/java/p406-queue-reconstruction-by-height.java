class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // check null condition
        if (people == null || people.length == 0 || people[0].length == 0)
            return new int[0][0];
        
        // sort by height, same height sort by k from small to big
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });  
        
        int n = people.length;
        ArrayList<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});
        }
        
        int[][] res = new int[n][2];
        int i = 0;
        for (int[] p : tmp) {
            res[i][0] = p[0];
            res[i++][1] = p[1];
        }
            
        return res;
    }
}
