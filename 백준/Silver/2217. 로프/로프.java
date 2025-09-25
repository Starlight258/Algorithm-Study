import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] w = new int[N];
        for (int i = 0; i < N; i++) {
            w[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(w); // 오름차순

        long ans = 0;
        // 오름차순 기준: i번째를 최약으로 할 때 k = N - i
        for (int i = 0; i < N; i++) {
            int k = N - i;
            long candidate = (long) w[i] * k; // long으로 캐스팅
            if (candidate > ans) ans = candidate; // 최대 갱신
        }

        System.out.println(ans);
    }
}