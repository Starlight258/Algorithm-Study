import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int n;
    private static int[] tiles;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tiles = new int[1001];

        tiles[1] = 1;
        tiles[2] = 2;
        for (int i = 3; i <= n; i++) {
            tiles[i] = (tiles[i - 1] + tiles[i - 2]) % 10_007;
        }

        System.out.println(tiles[n]);
    }

}
