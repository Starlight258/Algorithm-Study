import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int t;
    private static int[][] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        numbers = new int[41][2];

        numbers[0][0] = 1;
        numbers[1][1] = 1;

        for (int i = 2; i < 41; i++) {
            fibos(i);
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(numbers[n][0] + " " + numbers[n][1]);
        }
    }

    private static void fibos(final int number) {
        if (numbers[number][0] != 0 || numbers[number][1] != 0) {
            return;
        }

        numbers[number][0] = numbers[number - 1][0] + numbers[number - 2][0];
        numbers[number][1] = numbers[number - 1][1] + numbers[number - 2][1];
    }
}
