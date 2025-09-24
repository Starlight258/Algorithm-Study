import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] times = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }
            List<List<Integer>> buildings = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                buildings.add(new ArrayList<>());
            }
            int[] indegree = new int[n + 1];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                buildings.get(s).add(e);
                indegree[e]++;
            }
            int w = Integer.parseInt(br.readLine());

            int[] answers = new int[n + 1];
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                    answers[i] = times[i - 1];
                }
            }

            while (!q.isEmpty()) {
                Integer cur = q.poll();
                if (cur == w) {
                    break;
                }
                for (Integer next : buildings.get(cur)) {
                    indegree[next]--;
                    answers[next] = Math.max(answers[next], answers[cur] + times[next-1]);
                    if (indegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }
            System.out.println(answers[w]);
        }
    }

    // 순서 존재
    // indegree[i] ==0 일때 queue에 추가
    //
}
