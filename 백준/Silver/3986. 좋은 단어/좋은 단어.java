import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputString = new String[n];
        for (int i = 0; i < n; i++) {
            inputString[i] = br.readLine();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            String s = inputString[i];
            if (checkGoodWord(s)){
                answer++;
            }
        }
        System.out.println(answer);
    }

    static boolean checkGoodWord(String s) {
        Stack<Character> stk = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (!stk.isEmpty() && stk.peek() == c) {
                stk.pop();
                continue;
            }
            stk.push(c);
        }
        if (!stk.isEmpty()) {
            return false;
        }
        return true;
    }
}
