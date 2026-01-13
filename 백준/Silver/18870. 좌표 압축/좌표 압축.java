import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    /*
    수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
    Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 한다.
    X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.
     */
    /*
    5
    2 4 -10 4 -9
    -> 정렬 : -10 -9 2 4 4
    2 3 0 3 1
    이분 탐색 : target보다 작은 첫 인덱스(lowerbound)

    6
    1000 999 1000 999 1000 999
    -> 정렬 999 999 1000 1000 1000 999
    1 0 : 중복 제거
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] sortedNums = Arrays.copyOf(nums, n);
        Arrays.sort(sortedNums);
        List<Integer> uniqueNums = new ArrayList<>();
        uniqueNums.add(sortedNums[0]);
        for (int i = 1; i < n; i++) {
            if (sortedNums[i - 1] != sortedNums[i]) {
                uniqueNums.add(sortedNums[i]);
            }
        }

        // 하나씩 고르기
        StringBuilder sb = new StringBuilder();
        for (int target : nums) {
            // 이분 탐색 :
            int left = 0;
            int right = uniqueNums.size();
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (uniqueNums.get(mid) >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            sb.append(left).append(" ");
        }
        System.out.println(sb);
    }
}
