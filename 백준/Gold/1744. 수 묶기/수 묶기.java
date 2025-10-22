import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        List<Integer> positives = new ArrayList<>();  // > 1
        int ones = 0;                                  // == 1
        List<Integer> negatives = new ArrayList<>();  // <= -1
        int zeros = 0;                                 // == 0

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine().trim());
            if (x > 1) positives.add(x);
            else if (x == 1) ones++;
            else if (x == 0) zeros++;
            else negatives.add(x); // x <= -1
        }

        // 정렬
        positives.sort(Comparator.reverseOrder()); // 큰 수부터 묶음
        negatives.sort(Comparator.naturalOrder()); // 작은 수(절대값 큰)부터 묶음

        long ans = 0;

        // 1은 그대로 더함
        ans += ones;

        // 양수(>1) 페어링
        for (int i = 0; i < positives.size(); i += 2) {
            if (i + 1 < positives.size()) {
                ans += (long) positives.get(i) * positives.get(i + 1);
            } else {
                ans += positives.get(i);
            }
        }

        // 음수 페어링
        for (int i = 0; i < negatives.size(); i += 2) {
            if (i + 1 < negatives.size()) {
                ans += (long) negatives.get(i) * negatives.get(i + 1);
            } else {
                // 남은 음수 하나
                if (zeros > 0) {
                    // 0과 곱해 손실 제거
                    zeros--;
                } else {
                    ans += negatives.get(i);
                }
            }
        }

        System.out.println(ans);
    }
}