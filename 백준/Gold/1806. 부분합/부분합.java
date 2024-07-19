import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 합 구하기
        int left = 0, right = 0;
        int answer = Integer.MAX_VALUE;
        int sum = 0;
        while (left <= n && right <= n) {
            if (sum >= s) {
                if (sum >= s && right - left < answer) {
                    answer = right - left;
                }
                sum -= arr[left++];
            } else {
                sum += arr[right++];
            }
        }

        // 3. 정답 출력R
        if (answer == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
