import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stk = new Stack<>();
        for (Character c:s.toCharArray()){
            if (c == '('){
                stk.push('(');
            } else if (!stk.isEmpty()){
                stk.pop();
            } else return false;
        }
        if (!stk.isEmpty()) return false;
        return true;
    }
}