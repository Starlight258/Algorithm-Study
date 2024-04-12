import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stk= new Stack<>();
        int cnt = k;
        for (char n:number.toCharArray()){
            while (!stk.isEmpty() && n > stk.peek() && k>0){
                stk.pop();
                k--;
            }
            stk.push(n);
        }
        for (int i=0;i<number.length()-cnt;i++){
            answer.append(stk.get(i));
        }
       
        return answer.toString();
    }
}