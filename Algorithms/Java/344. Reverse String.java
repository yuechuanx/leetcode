class Solution {
    public String reverseString(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        int left = 0, right = s.length() - 1;
        char[] str = s.toCharArray();
        
        while (left < right) {
            char tmp = str[left];
            str[left++] = str[right];
            str[right--] = tmp;
        }
        
        return new String(str);
    }
}

class Solution 
{
    public String reverseString(String s) 
    {
        if(s == null || s.isEmpty())
            return s;
        
        char[] str = s.toCharArray();
        
        for(int start = 0, end = s.length() - 1; start < end; start++, end--)
        {
            char c = str[start];
            str[start] = str[end];
            str[end] = c;
        }
        return new String(str);
    }
}