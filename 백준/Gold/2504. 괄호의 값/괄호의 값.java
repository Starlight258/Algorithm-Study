import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stk = new Stack<>();
        boolean isValid = true;
        int answer = 0;
        int cnt = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stk.push(c);
                cnt *= 2;
            } else if (c == '[') {
                stk.push('[');
                cnt *= 3;
            } else {
                if (c == ')') {
                    if (stk.isEmpty() || stk.peek() != '(') {
                        isValid = false;
                        break;
                    }
                    if (str.charAt(i - 1) == '(') {
                        answer += cnt;
                    }
                    stk.pop();
                    cnt /= 2;
                } else if (c == ']') {
                    if (stk.isEmpty() || stk.peek() != '[') {
                        isValid = false;
                        break;
                    }
                    if (str.charAt(i - 1) == '[') {
                        answer += cnt;
                    }
                    stk.pop();
                    cnt /= 3;
                } else {
                    isValid = false;
                    break;
                }
            }
        }
        if (!isValid || !stk.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
