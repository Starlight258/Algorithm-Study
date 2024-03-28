import java.util.*;
class Solution {
    boolean solution(String str) {
        Stack<Character> stk = new Stack<>();
        boolean answer = true;
        for (char s:str.toCharArray()){
            if (s == '('){
                stk.push('(');
            } else {
                if (!stk.isEmpty() && stk.peek() == '('){
                    stk.pop();
                } else return false;
            }
        }
        if (!stk.isEmpty()) return false;

        return answer;
    }
}