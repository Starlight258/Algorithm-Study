import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
    정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

    X가 3으로 나누어 떨어지면, 3으로 나눈다.
    X가 2로 나누어 떨어지면, 2로 나눈다.
    1을 뺀다.
    정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
     */

    /*
    dp[x] = dp[x/3], dp[x/2], dp[x-1]
    dp[i] = i 만들때 연산 최소값
    dp[1] = 0
    dp[2] = 1
    dp[3] = 1
    dp[4] = dp[4/2]+1, dp[3]+1 =2
    dp[5] = dp[4] + 1
    Set 사용
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] p = new int[n + 1]; // p[i] = j : j까지의 i
        dp[1] = 0;
        for (int x = 2; x <= n; x++) {
            dp[x] = dp[x - 1] + 1;
            p[x] = x - 1;
            int divByTwo = dp[x / 2] + 1;
            if (x % 2 == 0 && dp[x] > divByTwo) {
                dp[x] = divByTwo;
                p[x] = x / 2;
            }
            int divByThree = dp[x / 3] + 1;
            if (x % 3 == 0 && dp[x] > divByThree) {
                dp[x] = divByThree;
                p[x] = x / 3;
            }
        }
        System.out.println(dp[n]);

        int v = n;
        System.out.print(v + " ");
        while (p[v] != 0) {
            System.out.print(p[v] + " ");
            v = p[v];
        }
    }

}
