import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        //2. 이진탐색 수행하기
        int max = houses[houses.length - 1];
        int left = 1;
        int right = houses[n - 1] - houses[0];
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 1;
            boolean isHome = false;
            int prev = houses[0];
            for (int i = 1; i < n; i++) {
                if (houses[i] - prev >= mid) {
                    prev = houses[i];
                    count++;
                }
            }
            if (count < c) {
                right = mid - 1;
            } else {
                answer = Math.max(mid, answer);
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
