import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tower = new int[n];
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            tower[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stk = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && tower[stk.peek()] < tower[i]) {
                answer[stk.pop()] = i + 1;
            }
            stk.push(i);
        }

        for (int a : answer) {
            System.out.print(a + " ");
        }
    }

    // 6 9 5 7 4
    // 1. stack에 끝에서부터 타워 인덱스 집어넣기
    // 2. 현재 타워가 stack.peek()보다 클 경우 : stack.pop() 인덱스에 현재 타워 인덱스 저장
}
