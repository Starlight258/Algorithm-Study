import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*
    KOI 부설 과학연구소에서는 많은 종류의 산성 용액과 알칼리성 용액을 보유하고 있다.
    각 용액에는 그 용액의 특성을 나타내는 하나의 정수가 주어져있다.
    산성 용액의 특성값은 1부터 1,000,000,000(10억)까지의 양의 정수로 나타내고, 알칼리성 용액의 특성값은 -1부터 -1,000,000,000(-10억)까지의 음의 정수로 나타낸다.
    같은 양의 두 용액을 혼합한 용액의 특성값은 혼합에 사용된 각 용액의 특성값의 합으로 정의한다.
    이 연구소에서는 같은 양의 두 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들려고 한다.
    예를 들어, 주어진 용액들의 특성값이 [-99, -2, -1, 4, 98]인 경우에는 특성값이 -99인 용액과 특성값이 98인 용액을 혼합하면
    특성값이 -1인 용액을 만들 수 있고, 이 용액의 특성값이 0에 가장 가까운 용액이다.

    참고로, 두 종류의 알칼리성 용액만으로나 혹은 두 종류의 산성 용액만으로 특성값이 0에 가장 가까운 혼합 용액을 만드는 경우도 존재할 수 있다.
    산성 용액과 알칼리성 용액의 특성값이 정렬된 순서로 주어졌을 때, 이 중 두 개의 서로 다른 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들어내는
    두 용액을 찾는 프로그램을 작성하시오.
     */
    /*
    [-99, -2, -1, 4, 98]
    two pointer
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int left = 0;
        int right = n - 1;
        int answerLeft = 0;
        int answerRight = n - 1;
        long answer = Long.MAX_VALUE;
        while (left < right) {
            long total = nums[left] + nums[right];
            // 값이 작으면 음수
            if (Math.abs(total) < answer) {
                answer = Math.abs(total);
                answerLeft = left;
                answerRight = right;
            }
            if (answer == 0) {
                break;
            }
            else if (total < 0) {
                // 합 키우기
                left++;
            } else {
                right--;
            }
        }
        System.out.println(nums[answerLeft] + " " + nums[answerRight]);
    }

}
