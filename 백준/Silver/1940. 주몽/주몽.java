import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 투포인터
        int left = 0;
        int right = num.length - 1;
        Arrays.sort(num);

        int answer = 0;
        while (left < right) {
            int sum = num[left] + num[right];
            if (sum < m) {
                left++;
            } else if (sum == m) {
                answer++;
                left++;
                right--;
            } else {
                right--;
            }
        }

        // 정답 출력
        System.out.println(answer);
    }
}
