import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tower = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            tower[i] = Integer.parseInt(st.nextToken());
        }
        //2. 스택 이용해서 구하기
        Stack<Integer> stk = new Stack<>();
        for (int i = 1; i <= n; i++) {
            while (!stk.isEmpty() && tower[stk.peek()] < tower[i]) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                System.out.print("0 ");
            } else {
                System.out.print(stk.peek() + " ");
            }
            stk.push(i);
        }
    }
}
