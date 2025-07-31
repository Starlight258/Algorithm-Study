import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder sb;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        hanoi(k, 1, 3, 2);
        System.out.println(count);
        System.out.println(sb);
    }

    public static void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            count++;
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        hanoi(n - 1, from, via, to);
        hanoi(1, from, to, via);
        hanoi(n - 1, via, to, from);
    }
}
