import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        for (int i=1;i<prices.length;i++){
            while (!stk.isEmpty() && prices[i]<prices[stk.peek()]){
                int pos = stk.pop();
                answer[pos] = i - pos;
            }
            
            stk.push(i);
        }
        for (int i=0;i<answer.length;i++){
            if (answer[i] == 0){
                answer[i] = answer.length - i - 1;
            }
        }
        return answer;
    }
}