import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<int[]> steps;

    public static void main(String[] args) {
        //1. 입력받기
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        //2. 하노이탑
        // 횟수 2^n-1
        BigInteger count = new BigInteger("2");
        System.out.println(count.pow(n).subtract(new BigInteger("1")));
        steps = new ArrayList<>();
        if (n <= 20) {
            hanoi(n, 1, 2, 3);
            for (int[] step : steps) {
                System.out.println(step[0] + " " + step[1]);
            }
        }
    }

    private static void hanoi(int n, int from, int via, int to) {
        if (n == 1) {
            steps.add(new int[]{from, to});
        } else {
            // n-1 개를 from -> via
            hanoi(n - 1, from, to, via);
            // 한개를 from -> to
            steps.add(new int[]{from, to});
            // n-1개를 via->to
            hanoi(n - 1, via, from, to);
        }
    }
}
