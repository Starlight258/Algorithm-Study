import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] lines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long left = 1;
        long right = 1;
        lines = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lines[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, lines[i]);
        }

        long answer = 0;
        while (left <= right) {
            long mid = (left + right) >>> 1;
            if (calculateTree(mid) >= m) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static long calculateTree(final long mid) {
        long answer = 0;
        for (int line : lines) {
            if (line >= mid) {
                answer += line - mid;
            }
        }
        return answer;
    }

    // 나무 m미터 필요, 높이 h 지정하여 자름
    // 높이의 최대값
    // long
}
