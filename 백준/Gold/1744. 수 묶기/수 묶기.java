import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        boolean hasOne = false;
        int oneNum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            if (nums[i] == 1) {
                hasOne = true;
                oneNum++;
            }
        }
        // 정렬
        Arrays.sort(nums);

        // 음수 저장하기
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 == nums.length && nums[i] <= 0) {
                result += nums[i];
            } else if (nums[i] <= 0 && nums[i + 1] <= 0) {
                result += nums[i] * nums[i + 1];
                i++;
            } else if (nums[i] <= 0) {
                result += nums[i];
            }
        }

        // 양수 저장하기
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == 0 && nums[i] > 1) {
                result += nums[i];
            } else if (nums[i] > 1 && nums[i - 1] > 1) {
                result += nums[i] * nums[i - 1];
                i--;
            } else if (nums[i] > 1) {
                result += nums[i];
            }
        }

        // 1 저장하기
        if (hasOne) {
            result += oneNum;
        }

        System.out.println(result);
    }
}
