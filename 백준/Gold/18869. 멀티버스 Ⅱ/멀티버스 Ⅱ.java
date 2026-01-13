import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    /*
    M개의 우주가 있고, 각 우주에는 1부터 N까지 번호가 매겨진 행성이 N개 있다.
    행성의 크기를 알고 있을때, 균등한 우주의 쌍이 몇 개인지 구해보려고 한다. 구성이 같은데 순서만 다른 우주의 쌍은 한 번만 센다.
    두 우주 A와 B가 있고, 우주 A에 있는 행성의 크기는 A1, A2, ..., AN, 우주 B에 있는 행성의 크기는 B1, B2, ..., BN라고 하자.
    두 우주의 행성 크기가 모든 1 ≤ i, j ≤ N에 대해서 아래와 같은 조건을 만족한다면, 두 우주를 균등하다고 한다.
    Ai < Aj → Bi < Bj
    Ai = Aj → Bi = Bj
    Ai > Aj → Bi > Bj
     */
    /*
    2 3
    1 3 2
    12 50 31 (1 3 2) : 12 31 50
    -> 같은 매턴끼리 횟수 구해서 k * (k-1) /2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Map<List<Integer>, Integer> orders = new HashMap<>();
        int[] nums;
        for (int i = 0; i < m; i++) { // 각각의 우주
            st = new StringTokenizer(br.readLine());
            List<Integer> order = new ArrayList<>();
            nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(st.nextToken());
            }
            int[] sorted = Arrays.copyOf(nums, n);
            Arrays.sort(sorted);
            for (int num : nums) {
                order.add(findIndex(num, sorted));
            }
            orders.put(order, orders.getOrDefault(order, 0) + 1);
        }

        long answer = 0;
        for (Integer value : orders.values()) {
            answer += (value * (value - 1)) / 2;
        }

        System.out.println(answer);
    }

    private static Integer findIndex(final int target, final int[] sorted) {
        int left = 0;
        int right = sorted.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (sorted[mid] == target) {
                return mid;
            } else if (sorted[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
