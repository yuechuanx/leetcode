/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap();
        for (Employee e : employees) 
            map.put(e.id, e);
        return dfs(id, map);
    }   
    
    private int dfs(int eid, Map<Integer, Employee> map) {
        Employee e = map.get(eid);
        int res = e.importance;
        for (Integer subid : e.subordinates)
            res += dfs(subid, map);
        return res;
    }
}