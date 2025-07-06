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
            if (answer.get(answer.size() - 1) < arr[i]) {
                answer.add(arr[i]);
            } else {
                int index = lowerBoundd(answer, arr[i]);
                answer.set(index, arr[i]);
            }
        }
        System.out.println(answer.size());
    }

    private static int lowerBoundd(final List<Integer> answer, final int num) {
        int left = 0;
        int right = answer.size() - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (answer.get(mid) < num) { // 처음으로 그 이상으로 가야함
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;

    }

}
