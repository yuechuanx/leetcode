class Solution {
  public int numJewelsInStones(String J, String S) {
    int res = 0;
    Set setJ = new HashSet();
    for(char j : J.toCharArray())
      setJ.add(j);
    for(char s : S.toCharArray())
      if(setJ.contains(s)) res++;
    return res;
  }
}
