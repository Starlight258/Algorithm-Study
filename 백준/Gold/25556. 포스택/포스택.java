import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Stack<Integer>> stacks = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            stacks.add(new Stack<>());
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            boolean isSuccess = false;
            for (Stack<Integer> stack : stacks) {
                if (!stack.isEmpty() && stack.peek() > num) {
                    stack.push(num);
                    isSuccess = true;
                    break;
                }
                if (stack.isEmpty()) {
                    stack.push(num);
                    isSuccess = true;
                    break;
                }
            }
            if (!isSuccess) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

}
