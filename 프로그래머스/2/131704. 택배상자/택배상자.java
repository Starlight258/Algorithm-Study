import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int pos=0;
        Stack<Integer> stk = new Stack<>();
        
        for (int i=0;i<order.length;i++){
            stk.push(i+1);
            while (!stk.isEmpty() && stk.peek()==order[pos]){
                answer++;
                stk.pop();
                pos++;
            }
        }
        return answer;
    }
}