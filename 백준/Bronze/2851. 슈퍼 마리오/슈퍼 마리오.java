import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int diff = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int number = Integer.parseInt(br.readLine());
            sum += number;
            int currentDiff = Math.abs(100 - sum);
            if (currentDiff <= diff) {
                diff = currentDiff;
                answer = sum;
            }
            if (currentDiff > diff) {
                break;
            }
        }
        System.out.println(answer);
    }
}
