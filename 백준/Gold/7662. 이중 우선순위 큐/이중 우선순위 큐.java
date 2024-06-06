import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                switch (cmd) {
                    case "I":
                        minPQ.offer(num);
                        maxPQ.offer(num);
                        map.put(num, map.getOrDefault(num, 0) + 1);
                        break;
                    case "D":
                        if (map.size() == 0) {
                            continue;
                        }
                        if (num == 1) {
                            delete(maxPQ);
                        } else {
                            delete(minPQ);
                        }
                        break;
                }
            }
            if (map.size() == 0) {
                sb.append("EMPTY\n");
                continue;
            }
            int result = delete(maxPQ);
            sb.append(result + " ");
            if (map.size() > 0) {
                result = delete(minPQ);
            }
            sb.append(result + "\n");

            minPQ.clear();
            maxPQ.clear();
            map.clear();
        }
        System.out.println(sb);
    }

    private static int delete(PriorityQueue<Integer> pq) {
        int num = 0;
        while (true) {
            num = pq.poll();
            int cnt = map.getOrDefault(num, 0);
            if (cnt == 0) {
                continue;
            }
            if (cnt == 1) {
                map.remove(num);
            } else {
                map.put(num, cnt - 1);
            }
            break;
        }
        return num;
    }
}
