import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);

        for (int i = 1; i < n; i++) {
            int num = arr[i];
            if (num > answer.get(answer.size() - 1)) {
                answer.add(num);
            } else {
                int index = lowerBound(answer, num);
                answer.set(index, num);
            }
        }

        System.out.println(answer.size());
    }

    private static int lowerBound(final List<Integer> answer, final int target) {
        int left = 0;
        int right = answer.size();
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (answer.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
