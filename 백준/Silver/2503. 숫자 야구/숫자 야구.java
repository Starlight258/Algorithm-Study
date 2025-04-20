import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Boolean> numbers = new HashMap<>();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 1; k <= 9; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    numbers.put(i * 100 + j * 10 + k, true);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            for (Entry<Integer, Boolean> entry : numbers.entrySet()) {
                if (!entry.getValue()) {
                    continue;
                }
                int number = entry.getKey();
                int possibleStrike = 0;
                int possibleBall = 0;
                for (int j = 1; j <= 100; j *= 10) {
                    int digit = (target / j) % 10;
                    if (digit == (number / j) % 10) {
                        possibleStrike++;
                        continue;
                    }
                    if (String.valueOf(number).contains(String.valueOf(digit))) {
                        possibleBall++;
                    }
                }
                if ((strike != possibleStrike) || (ball != possibleBall)) {
                    numbers.put(number, false);
                }
            }
        }
        int answer = 0;
        for (Boolean value : numbers.values()) {
            if (value) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
