import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        // 이분 탐색 수행
        int left = Arrays.stream(arr).max().getAsInt();
        int right = Arrays.stream(arr).sum();
        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            int cnt = 0;
            for (int j : arr) {
                if (sum + j > mid) {
                    cnt++;
                    sum = 0;
                }
                sum += j;
            }
            if (sum != 0) {
                cnt++;
            }

            if (cnt <= m) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 정답 출력
        System.out.println(answer);
    }
}
