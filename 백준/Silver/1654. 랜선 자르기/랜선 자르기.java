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
        long left = 1;
        long right = 0;
        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, lines[i]);
        }

        // 이진 탐색
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) >>> 1;
            if (calculate(mid) >= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static long calculate(final long mid) {
        long answer = 0;
        for (int line : lines) {
            answer += line / mid;
        }
        return answer;
    }

    // N개의 렌선 만들어야함, K개의 랜선
    // 만들 수 있는 가장 최대의 랜선
    // 이진 탐색

}
