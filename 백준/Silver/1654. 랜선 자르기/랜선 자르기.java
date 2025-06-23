import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        List<Long> lines = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            lines.add(Long.parseLong(br.readLine()));
        }

        System.out.println(getMaxLength(lines, n));
    }

    public static boolean isPossible(List<Long> lines, long target, int n) {
        long count = 0;
        for (Long line : lines) {
            count += line / target;
        }
        return count >= n;
    }

    public static long getMaxLength(List<Long> lines, int n) {
        long left = 1;
        long right = 1;
        long answer = 0;
        for (Long line : lines) {
            right = Math.max(right, line);
        }
        while (left <= right) {
            long mid = (right - left) / 2 + left;

            if (isPossible(lines, mid, n)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

}
