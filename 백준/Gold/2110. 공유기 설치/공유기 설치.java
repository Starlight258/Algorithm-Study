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
        long right = distances[distances.length-1];
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
        long count = 1;
        long prev = distances[0];
        for (int distance : distances) {
            if (distance - prev >= mid) {
                count++;
                prev = distance;
            }
        }
        return count;
    }

}
