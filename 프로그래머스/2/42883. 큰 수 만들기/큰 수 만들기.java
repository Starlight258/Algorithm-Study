import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int last = Integer.parseInt(String.valueOf(number.charAt(0)));
        Stack<Character> stk = new Stack<>();
        for (char c:number.toCharArray()){
            while (!stk.isEmpty() && stk.peek()<c && k>0){
                stk.pop();
                k--;
            }
            stk.push(c);
        }
        for (int i=0;i<stk.size()-k;i++){
            answer += stk.get(i);
        }
        return answer;
    }
}