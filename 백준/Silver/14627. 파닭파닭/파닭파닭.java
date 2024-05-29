import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int s = input[0];
        int c = input[1];

        int[] arr = new int[s];
        for (int i = 0; i < s; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        // 이진 탐색 수행
        long left = 1;
        long right = 1_000_000_000;
        long answer = 0;
        long answerMid = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            long cnt = 0;
            for (int a : arr) {
                cnt += a / mid;
            }

            if (cnt < c) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answerMid = Math.max(answerMid, mid);
            }
        }

        // 남은 파 구하기
        answer = sum - answerMid * c;

        // 정답 출력
        System.out.println(answer);
    }
}
