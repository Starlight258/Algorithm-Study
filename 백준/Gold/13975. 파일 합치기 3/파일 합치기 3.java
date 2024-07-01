import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < k; i++) {
                pq.add(Long.valueOf(arr[i]));
            }
            long sum = 0;
            while (!pq.isEmpty()) {
                long a = pq.poll();
                if (pq.isEmpty()) {
                    sb.append(sum).append("\n");
                    break;
                }
                long b = pq.poll();
                pq.add(a + b);
                sum += a + b;
            }
            pq.clear();
        }
        System.out.println(sb);
    }
}
