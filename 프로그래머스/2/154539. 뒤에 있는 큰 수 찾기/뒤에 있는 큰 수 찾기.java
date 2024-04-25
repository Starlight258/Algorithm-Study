import java.util.*;
class Solution {
    class Num{
        int number;
        int idx;
        Num(int number, int idx){
            this.number = number;
            this.idx = idx;
        }
    }
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Num> stk = new Stack<>();
        for (int i=0;i<numbers.length;i++){
            while (!stk.isEmpty() && stk.peek().number < numbers[i]){
                Num e = stk.pop();
                answer[e.idx] = numbers[i];
            }
            stk.push(new Num(numbers[i], i));
        }
        return answer;
    }
}