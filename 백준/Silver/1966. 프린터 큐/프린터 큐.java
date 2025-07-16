import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            Queue<int[]> q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int element = Integer.parseInt(st.nextToken());
                pq.offer(element);
                q.offer(new int[]{i, element});
            }

            int count = 0;
            while (!q.isEmpty()) {
                int[] poll = q.poll();
                if (Objects.equals(poll[1], pq.peek())) {
                    count++;
                    pq.poll();
                    if (poll[0] == m) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    q.offer(poll);
                }
            }
        }
    }
}
