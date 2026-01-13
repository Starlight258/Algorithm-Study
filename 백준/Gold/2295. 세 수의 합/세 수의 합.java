import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    /*
    N(5 ≤ N ≤ 1,000)개의 자연수들로 이루어진 집합 U가 있다.
    이 중에서 적당히 세 수를 골랐을 때, 그 세 수의 합 d도 U안에 포함되는 경우가 있을 수 있다. 이러한 경우들 중에서, 가장 큰 d를 찾으라.

    예를 들어 {2, 3, 5, 10, 18}와 같은 집합이 있다고 하자. 2+3+5 = 10이 되고, 이 수는 집합에 포함된다.
    하지만 3+5+10 = 18이 되고, 이 경우가 세 수의 합이 가장 커지는 경우이다.
     */
    /*
    1. (a+b) + c = d
    a + b = d - c;
    5 8 15 28

    2. 이진탐색
    twosum 배열에서 d-c 찾기
     */
    private static int n;
    private static int[] nums;
    private static List<Integer> sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums); // 오름차순
        // 합 구하기
        sum = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum.add(nums[i] + nums[j]);
            }
        }
        Collections.sort(sum);
        
        // 이진탐색
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                boolean hasFind = binarySearch(nums[i] - nums[j]);
                if (hasFind) {
                    System.out.println(nums[i]);
                    return;
                }
            }
        }
    }

    private static boolean binarySearch(int target) {
        int left = 0;
        int right = sum.size() - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (sum.get(mid) == target) {
                return true;
            } else if (sum.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

}
