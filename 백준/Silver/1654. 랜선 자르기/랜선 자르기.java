import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] lines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        lines = new int[k];
        long right = 0;
        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            right = Math.max(lines[i], right);
        }

        long left = 1;
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) >>> 1;
            if (cutLine(mid) >= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static long cutLine(final long mid) {
        long count = 0;
        for (int line : lines) {
            count += line / mid;
        }
        return count;
    }

}
