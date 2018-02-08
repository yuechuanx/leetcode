/*
The history of Java switch statement has a problem (prior to jdk 1.7) like only valid for non-long type. Even after jdk 1.7, If you pass a String type variable, you cannot pass the variable like Object str = “foo” to switch statement. It has other minor issues you need be careful when you want to use it. I guess that’s the main reason for people like me refuse to use Java switch.

*/
class Solution {
    public boolean judgeCircle(String moves) {
        int h = 0;
        int v = 0;
        for(char ch : moves.toCharArray()) {
            if(ch == 'U') v++;
            else if(ch == 'D') v--;
            else if(ch == 'L') h--;
            else if(ch == 'R') h++;
        }
        return v == 0 && h == 0;
    }
}
