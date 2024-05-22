import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] jewels = new int[m];
        int maxJewel = 0;
        for (int i = 0; i < m; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
            maxJewel = Math.max(maxJewel, jewels[i]);
        }

        //2. 이진탐색 수행
        int answer = Integer.MAX_VALUE;
        int left = 1;
        int right = maxJewel;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                cnt += jewels[i] / mid;
                if (jewels[i] % mid != 0) {
                    cnt++;
                }
            }

            if (cnt <= n) {
                right = mid - 1;
                answer = Math.min(answer, mid);
            } else left = mid + 1;
        }

        //3. 정답 출력
        System.out.println(answer);
    }
}
