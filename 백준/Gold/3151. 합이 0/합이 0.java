import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
    Elly는 예상치 못하게 프로그래밍 대회를 준비하는 학생들을 가르칠 위기에 처했다.
    대회는 정확히 3명으로 구성된 팀만 참가가 가능하다. 그러나 그녀가 가르칠 학생들에게는 큰 문제가 있었다.
    코딩 실력이 좋으면 팀워크가 떨어지고, 팀워크가 좋을수록 코딩 실력이 떨어진다.
    그리고 출전하고자 하는 대회는 코딩 실력과 팀워크 모두가 중요하다.

    Elly는 그녀가 가르칠 수 있는 모든 학생들의 코딩 실력을 알고 있다.
    각각의 코딩 실력 Ai는 -10000부터 10000 사이의 정수로 표시되어 있다.
    그녀는 팀워크와 코딩 실력이 모두 적절한 팀을 만들기 위해, 세 팀원의 코딩 실력의 합이 0이 되는 팀을 만들고자 한다. 이러한 조건 하에,
    그녀가 대회에 출전할 수 있는 팀을 얼마나 많이 만들 수 있는지를 계산하여라.

    N명의 학생들의 코딩 실력 Ai가 -10000부터 10000사이의 정수로 주어질 때, 합이 0이 되는 3인조를 만들 수 있는 경우의 수를 구하여라.
     */
    /*
    a+b+c = 0
    a -> 정하고 b, c 투포인터

    10
    2 -5 2 3 -4 7 -4 0 1 -6
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

        long answer = 0;
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                if (total == 0) {
                    if (nums[left] == nums[right]) {
                        int count = right - left + 1;
                        answer += (long) count * (count - 1) / 2;
                        break;
                    }
                    int leftCount = 1;
                    int rightCount = 1;

                    while (left + 1 < right && nums[left] == nums[left + 1]) {
                        leftCount++;
                        left++;
                    }
                    while (right - 1 > left && nums[right] == nums[right - 1]) {
                        rightCount++;
                        right--;
                    }
                    answer += (long) leftCount * rightCount;

                    left++;
                    right--;
                }
                else if (total < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(answer);
    }
}
