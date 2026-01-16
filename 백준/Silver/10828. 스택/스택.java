import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {
    /*
    정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

    명령은 총 다섯 가지이다.

    push X: 정수 X를 스택에 넣는 연산이다.
    pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    size: 스택에 들어있는 정수의 개수를 출력한다.
    empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
    top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     */
    /*
    14
    push 1
    push 2
    top
    size
    empty
    pop
    pop
    pop
    size
    empty
    pop
    push 3
    empty
    top
         */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stk = new ArrayDeque<Integer>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            if (tokens.length == 2) {
                stk.push(Integer.parseInt(tokens[1]));
                continue;
            }
            switch (tokens[0]){
                case "pop":
                    if (stk.isEmpty()) {
                        addValue(sb,-1);
                        continue;
                    }
                    addValue(sb, stk.pop());
                    break;
                case "size":
                    addValue(sb, stk.size());
                    break;
                case "empty":
                    if (stk.isEmpty()) {
                        addValue(sb, 1);
                        continue;
                    }
                    addValue(sb, 0);
                    break;
                case "top":
                    if (stk.isEmpty()) {
                        addValue(sb,-1);
                        continue;
                    }
                    addValue(sb, stk.peek());
                    break;
            }
        }
        System.out.println(sb);
    }

    private static void addValue(StringBuilder sb, int value){
        sb.append(value).append("\n");
    }

}
