import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
    준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.

    동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
     */
    /*
    동전 간 배수 관계 성립 -> 가장 큰 동전부터 차례대로 최대한 많이 사용
    4200 = 1000 * 4 + 100 * 2 = 6
    10 4200
    1
    5
    10
    50
    100
    500
    1000
    5000
    10000
    50000

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            int coin = coins[i];
            if (coin <= k) {
                count += k / coin;
                k %= coin;
            }
        }
        System.out.println(count);
    }
}
