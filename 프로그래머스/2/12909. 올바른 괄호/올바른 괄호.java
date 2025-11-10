import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stk = new Stack<>();
        for (char c:s.toCharArray()){
            if (c=='(') stk.push(c);
            else{
                if (stk.isEmpty()){
                    return false;
                }
                stk.pop();
            }
        }
        if (!stk.isEmpty()) return false;

        return answer;
    }
    
    // ()
    // Stack -> (이면 추가, )는 pop(empty면 false, 
}