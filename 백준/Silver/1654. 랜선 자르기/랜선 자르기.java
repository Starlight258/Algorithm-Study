import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] line = new long[k];
        for (int i = 0; i < k; i++) {
            line[i] = Long.parseLong(br.readLine());
        }
        // 이진 탐색
        long left = 1;
        long right = Arrays.stream(line).max().getAsLong();
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 0; i < line.length; i++) {
                cnt += line[i] / mid;
            }
            if (cnt < n) {
                right = mid - 1;
            } else { // n개이상의 랜선
                left = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        System.out.println(answer);
    }
}
