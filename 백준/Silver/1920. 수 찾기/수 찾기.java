import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        int m = Integer.parseInt(br.readLine());
        int[] finders = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            finders[i] = Integer.parseInt(st.nextToken());
            System.out.println(findd(finders[i])? 1 : 0);
        }
    }

    private static boolean findd(final int finder) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (numbers[mid] == finder) {
                return true;
            } else if (numbers[mid] < finder) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
