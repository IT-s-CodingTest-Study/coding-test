import java.util.*;
class Solution{
    public String solution(String number, int k) {
        Stack<Character> s = new Stack<>();

        for (char num : number.toCharArray()) {
            while (!s.isEmpty() && k > 0 && s.peek() < num) {
                s.pop();
                k--;
            }
            s.push(num);
        }

        while (k > 0 && !s.isEmpty()) {
            s.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        for (char ch : s) {
            result.append(ch);
        }

        return result.toString();
    }
   
}