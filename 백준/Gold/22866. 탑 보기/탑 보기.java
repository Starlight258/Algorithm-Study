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

        int[] h = new int[n + 1];
        int[] cnt = new int[n + 1];
        int[] near = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
            near[i] = -100_000;
        }

        //2. 반복하기
        Stack<Integer> stack = new Stack<>();
        // 왼쪽 계산
        for (int i = 1; i <= n; i++) {
            while (!stack.isEmpty() && h[stack.peek()] <= h[i]) {
                stack.pop();
            }
            cnt[i] = stack.size();
            if (cnt[i] > 0) {
                near[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        // 오른쪽 계산
        for (int i = n; i > 0; i--) {
            while (!stack.isEmpty() && h[stack.peek()] <= h[i]) {
                stack.pop();
            }
            cnt[i] += stack.size();
            if (stack.size() > 0 && stack.peek() - i < i - near[i]) {
                near[i] = stack.peek();
            }
            stack.push(i);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(cnt[i]);
            if (cnt[i] > 0) {
                sb.append(" ").append(near[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
