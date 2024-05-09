import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static boolean[] isPrime;

    static void makePrime(int num) {
        isPrime = new boolean[num + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            for (int j = i * i; j <= num; j += i) {
                isPrime[j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        makePrime(n);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (isPrime[i]) {
                list.add(i);
            }
        }

        //2. 투포인터
        int answer = 0;
        int left = 0;
        int right = 0;
        int rangeSum = 0;
        while (true) {
            if (rangeSum >= n) {
                rangeSum -= list.get(left++);
            } else if (right == list.size()) {
                break;
            } else {
                rangeSum += list.get(right++);
            }
            if (rangeSum == n) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
