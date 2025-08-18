import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Deque<Integer> deque;
        StringBuilder sb;
        while (t-- > 0) {
            String command = br.readLine();
            boolean isEnd = false;
            int size = Integer.parseInt(br.readLine());
            deque = new LinkedList<>();
            st = new StringTokenizer(br.readLine().replace('[', ' ').replace(']', ' ').trim(), ",");
            while (st.hasMoreTokens()) {
                deque.offerLast(Integer.parseInt(st.nextToken()));
            }
            boolean isFalse = false;
            for (char c : command.toCharArray()) {
                if (c == 'R') {
                    isEnd = !isEnd;
                } else {
                    if (deque.isEmpty()) {
                        isFalse = true;
                        break;
                    }
                    if (isEnd) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }
            sb = new StringBuilder();
            if (isFalse) {
                sb.append("error");
            } else {
                if (deque.isEmpty()) {
                    System.out.println("[]");
                    continue;
                }
                sb.append("[");
                if (!isEnd) {
                    for (Integer i : deque) {
                        sb.append(i).append(",");
                    }
                } else {
                    List<Integer> list = new ArrayList<>(deque);
                    Collections.reverse(list);
                    for (Integer i : list) {
                        sb.append(i).append(",");
                    }
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append("]");
            }
            System.out.println(sb);
        }
    }
}
