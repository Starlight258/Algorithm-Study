import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        int count = k;
        for (int i=0;i<number.length();i++){
            char c = number.charAt(i);
            while (count>0 && !stk.isEmpty() && c>stk.peek()){
                stk.pop();
                count--;
            }
            stk.push(c);
        }
        while (!stk.isEmpty()){
            answer.append(stk.pop());
        }
        return answer.reverse().toString().substring(0, number.length()-k);
    }
}