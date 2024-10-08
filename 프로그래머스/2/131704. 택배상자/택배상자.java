import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stk = new Stack<>();
        int pos = 1;
        for (int i=0;i<order.length;i++){
            while (pos < order[i]){
                stk.push(pos++);
            } 
            if (pos == order[i]){
                answer++;
                pos++;
                continue;
            }
            if (pos > order[i]){
                if (stk.peek() == order[i]){
                    stk.pop(); 
                    answer++;
                } else break;
            }
        }
        return answer;
    }
}