import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stk = new Stack<>();
        int n = number.length();
        int count = 0;
        for (int i=0;i<n;i++){
            int num = number.charAt(i) - '0';
            while (!stk.isEmpty() && stk.peek() < num && count < k){
                stk.pop();
                count++;
            } 
            stk.push(num);
        }
        List<Integer> answer = new ArrayList<>();
        while (!stk.isEmpty()){
            answer.add(stk.pop());
        }
        StringBuilder result = new StringBuilder();
        for (int i=answer.size()-1;i>=0;i--){
            result.append(answer.get(i));
            if (result.length() == n-k){
                break;
            }
        }
        return result.toString();
    }
}