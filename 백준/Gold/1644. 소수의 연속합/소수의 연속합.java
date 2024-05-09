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

        //1. 누적합
        int total = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (isPrime[i]) {
                total += i;
                list.add(total);
            }
        }

        //2. 투포인터
        int answer = 0;

        int left = 0;
        int right = 1;
        while (right < list.size() && left < right) {
            int rangeSum = list.get(right) - list.get(left);
            if (rangeSum < n) {
                right++;
            } else {
                if (rangeSum == n) {
                    answer++;
                }
                left++;
            }
        }
        for (Integer integer : list) {
            if (integer == n) {
                answer++;
                break;
            }
        }

        System.out.println(answer);
    }
}
