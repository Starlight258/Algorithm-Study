import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> answer = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        // bfs 수행
        Queue<Integer> q = new LinkedList<>();
        int[] prev = new int[100001];
        int[] visited = new int[100001];
        q.add(n);
        visited[n] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == k) {
                break;
            }
            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next < 0 || next > 100000) {
                    continue;
                }
                if (visited[next] != 0) {
                    continue;
                }
                q.add(next);
                visited[next] = visited[now] + 1;
                prev[next] = now;
            }
        }
        sb.append(visited[k] - 1).append("\n");
        Stack<Integer> stack = new Stack<>();
        while (k != n) {
            stack.push(k);
            k = prev[k];
        }
        stack.push(n);

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}
