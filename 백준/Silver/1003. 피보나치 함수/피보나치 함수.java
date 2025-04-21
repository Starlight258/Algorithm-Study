import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Map<Integer, int[]> dp = new HashMap<>();
        dp.put(0, new int[]{1, 0});
        dp.put(1, new int[]{0, 1});

        for (int number = 0; number <= 40; number++) {
            fibonacci(number, dp);
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] fibonacci = fibonacci(n, dp);
            System.out.println(fibonacci[0] + " " + fibonacci[1]);
        }
    }

    private static int[] fibonacci(final int number, final Map<Integer, int[]> dp) {
        if (dp.containsKey(number)) {
            return dp.get(number);
        }
        int[] first = fibonacci(number - 1, dp);
        int[] second = fibonacci(number - 2, dp);
        int[] sum = {first[0] + second[0], first[1] + second[1]};
        dp.put(number, sum);
        return sum;
    }
}
