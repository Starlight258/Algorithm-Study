import java.util.*;

class Solution {

    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        // 스택 저장
        Stack<Integer> stk = new Stack<>();
        
        // 순회하면서 뒷 큰수 구하기
        for (int i=0;i<n;i++){
            int cur = numbers[i];
            while (!stk.isEmpty() && numbers[stk.peek()] < cur){
                int index = stk.pop();
                answer[index] = cur;
            }
            stk.push(i);
        }
        
        return answer;
    }
    // 뒷 큰 수 : 자신보다 크면서 뒤에서 가장 가까이 있는 수
    // result : -1로 초기화
    // stack에서 
    // if (stk.peek() <= cur) : pop + 해당 인덱스에 cur 저장 
    // else : push
    // 스택에 모든 수 저장: numbers 하나씩 돌면서 number < stk.peek()이면 result에 저장, 그렇지 않으면 poll(), 원소가 없을 경우 -1
}