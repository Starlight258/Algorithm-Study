import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
    0과 1로만 이루어진 수를 이진수라 한다. 이러한 이진수 중 특별한 성질을 갖는 것들이 있는데, 이들을 이친수(pinary number)라 한다. 이친수는 다음의 성질을 만족한다.

    이친수는 0으로 시작하지 않는다.
    이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
    예를 들면 1, 10, 100, 101, 1000, 1001 등이 이친수가 된다. 하지만 0010101이나 101101은 각각 1, 2번 규칙에 위배되므로 이친수가 아니다.

    N(1 ≤ N ≤ 90)이 주어졌을 때, N자리 이친수의 개수를 구하는 프로그램을 작성하시오.
     */
    /*
    int[][] count = new int[num][2] : {0의 개수, 1의 개수)
    count[i][0] = count[i-1][0] + count[i-1][1];
    count[i][1] = count[i-1][0];
    0의 개수 -> +1, +1
    1의 개수 -> +1, +0
    count[1] = {0, 1} -> 1
    count[2] = {1, 0} -> 1
    count[3] = {1, 1} -> 2
    count[4] = {2, 1} -> 3 (a+b)
    count[5] = {3, 2} -> 5

    1
    10
    100 -> 0뒤에는 0,1
    101 -> 1뒤에는 0
    1000 -> 0 뒤에는 0,1
    1001 -> 1 뒤에는 0
    1010 -> 0 뒤에는 0,1
    10000
    10001
    10010
    10100
    10101
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] count = new long[91][2];
        count[1][0] = 0;
        count[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            count[i][0] = count[i - 1][0] + count[i - 1][1];
            count[i][1] = count[i - 1][0];
        }
        System.out.println(count[n][0] + count[n][1]);
    }
}
