import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    /*
    하나 이상의 연속된 소수의 합으로 나타낼 수 있는 자연수들이 있다. 몇 가지 자연수의 예를 들어 보면 다음과 같다.

    3 : 3 (한 가지)
    41 : 2+3+5+7+11+13 = 11+13+17 = 41 (세 가지)
    53 : 5+7+11+13+17 = 53 (두 가지)
    하지만 연속된 소수의 합으로 나타낼 수 없는 자연수들도 있는데, 20이 그 예이다. 7+13을 계산하면 20이 되기는 하나 7과 13이 연속이 아니기에 적합한 표현이 아니다. 또한 한 소수는 반드시 한 번만 덧셈에 사용될 수 있기 때문에, 3+5+5+7과 같은 표현도 적합하지 않다.

    자연수가 주어졌을 때, 이 자연수를 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 구하는 프로그램을 작성하시오.
     */
    /*
    소수 배열(에라테네스의 체) 만든 후 prefix 구함
    i~j합 : prefix[j] - prefix[i-1]
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] prime = new boolean[n + 1];
        List<Integer> primes = makePrimess(prime, n);
        long sum = 0;
        int left = 0;
        int right = 0;
        int answer = 0;
        int pSize = primes.size();
        while (left <= right && right <= pSize) {
            if (sum >= n) {
                if (sum == n) {
                    answer++;
                }
                sum -= primes.get(left);
                left++;
            } else if (right == pSize) {
                break;
            } else {
                sum += primes.get(right);
                right++;
            }
        }
        System.out.println(answer);
    }

    private static List<Integer> makePrimess(final boolean[] isPrime, final int n) {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }


}
