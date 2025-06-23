import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(numbers);

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int count = upperBound(numbers, target) - lowerBound(numbers, target);
            sb.append(count).append(" ");
        }
        System.out.println(sb);
    }


    // 값을 초과하는 처음 위치
    private static int upperBound(final int[] numbers, final int target) {
        int left = 0;
        int right = numbers.length;

        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (numbers[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // 값이 존재하는 처음 위치
    private static int lowerBound(final int[] numbers, final int target) {
        int left = 0;
        int right = numbers.length;

        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


}
