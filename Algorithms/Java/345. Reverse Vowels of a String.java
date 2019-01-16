// Two-Pointer 
class Solution {
    public String reverseVowels(String s) {
        int left = 0, right = s.length() - 1;
        char[] str = s.toCharArray();
        while(left < right) {
            if(isVowel(str[left]) && isVowel(str[right])) {
                //swap(str[left++], str[right--]);
                char tmp = str[left];
                str[left++] = str[right];
                str[right--] = tmp;
            } else if(isVowel(str[left])) {
                --right;
            } else {
                ++left;
            }
        }
        // not use str.toString() will lead to 乱码
        return new String(str);
    }
    
    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }  
}





public class Solution {
public String reverseVowels(String s) {
    if(s == null || s.length()==0) return s;
    String vowels = "aeiouAEIOU";
    char[] chars = s.toCharArray();
    int start = 0;
    int end = s.length()-1;
    while(start<end){
        
        while(start<end && !vowels.contains(chars[start]+"")){
            start++;
        }
        
        while(start<end && !vowels.contains(chars[end]+"")){
            end--;
        }
        
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
        
        start++;
        end--;
    }
    return new String(chars);
}
}

