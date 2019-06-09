class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> st = new Stack();
        st.push(0);
        
        while (!st.isEmpty()) {
            int node = st.pop();
            for (int neig : rooms.get(node)) {
                if (!seen[neig]) {
                    seen[neig] = true;
                    st.push(neig);
                }
            } // END-FOR 
        } // END-WHILE
        
        for (boolean room : seen)
            if (!room) return false;
        return true;
    }
}