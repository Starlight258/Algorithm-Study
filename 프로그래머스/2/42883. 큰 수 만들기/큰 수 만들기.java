import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder("");
        int answerLength = number.length() - k;
        Stack<Character> stk= new Stack<>();
        for (char c:number.toCharArray()){
            while (!stk.isEmpty() && stk.peek()<c && k>0){
                stk.pop();
                k--;
            }
            stk.push(c);
        }

        for (int i=0;i<answerLength;i++){
            answer.append(stk.get(i));
        }
       
        return answer.toString();
    }
}