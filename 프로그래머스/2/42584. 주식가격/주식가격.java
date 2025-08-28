import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i=0;i<prices.length;i++){
            while (!stk.isEmpty() && prices[stk.peek()] > prices[i]){
                int prev = stk.pop();
                answer[prev] = i - prev;
            }
            stk.push(i);
        }
        while (!stk.isEmpty()){
            int index = stk.pop();
            answer[index] = n -1 - index;
        }
        return answer;
    }
    // 1 2 3 2 3
    // 감소할 경우 -> 인덱스 차이, pop
    // 감소하지 않을 경우 -> n-(index+1) = n-1-index
}