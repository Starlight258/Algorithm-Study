import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int c;
    private static int[] distances;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        distances = new int[n];
        for (int i = 0; i < n; i++) {
            distances[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(distances);

        long left = 1;
        long right = distances[distances.length - 1] - distances[0];
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) >>> 1;
            if (checkDistance(mid) >= c) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    private static long checkDistance(final long mid) {
        int count = 1;
        int last = distances[0];
        for (int i = 1; i < distances.length; i++) {
            int distance = distances[i];
            if (distance - last >= mid) {
                count++;
                last = distance;
                if (count >= c) {
                    break;
                }
            }
        }
        return count;
    }
}
