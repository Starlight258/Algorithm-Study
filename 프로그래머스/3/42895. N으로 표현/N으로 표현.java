import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        List<Set<Integer>> dp = new ArrayList<>(9);
        for (int i = 0; i <= 8; i++) dp.add(new HashSet<>());

        for (int k = 1; k <= 8; k++) {
            // 1) 이어붙이기 수: N, NN, NNN ...
            int concat = concatN(N, k);
            dp.get(k).add(concat);
            if (concat == number) return k;

            // 2) 분할 i + (k-i) 조합
            for (int i = 1; i < k; i++) {
                Set<Integer> A = dp.get(i);
                Set<Integer> B = dp.get(k - i);

                for (int a : A) {
                    for (int b : B) {
                        dp.get(k).add(a + b);
                        dp.get(k).add(a - b);
                        dp.get(k).add(b - a);
                        dp.get(k).add(a * b);
                        if (b != 0) dp.get(k).add(a / b);
                        if (a != 0) dp.get(k).add(b / a);
                    }
                }
            }

            if (dp.get(k).contains(number)) return k;
        }
        return -1;
    }

    private int concatN(int N, int times) {
        int val = 0;
        for (int i = 0; i < times; i++) val = val * 10 + N;
        return val;
    }
}