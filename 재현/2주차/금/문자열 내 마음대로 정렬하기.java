import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        Arrays.sort(strings, (str1, str2) -> {
           return str1.charAt(n) == str2.charAt(n) ? str1.compareTo (str2) : str1.charAt(n) - str2.charAt(n);
        });
        
        
        return strings;
    }
}
