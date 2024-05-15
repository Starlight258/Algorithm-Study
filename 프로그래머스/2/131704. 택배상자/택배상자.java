import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        if (order.length==1){
            return 1;
        }
        Stack<Integer> stk = new Stack<>();
        int next = 1;
        for (int i=0;i<order.length;i++){
            if (order[i] == next && next<=order.length){
                next++;
                answer++;
                continue;
            }
            if (!stk.isEmpty() && order[i] == stk.peek()){
                stk.pop();
                answer++;
                continue;
            }
            if (next>order.length) continue;
            boolean flag = false;
            for (int j=next;j<=order.length;j++){
                next++;
                if (j==order[i]){
                    answer++;
                    flag = true;
                    break;
                } 
                stk.push(j);
            }
            if (!flag) break; 
        }
        return answer;
    }
}