import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            int ny = 0, nx = 0, d = 0;
            int maxY = 0, minY = 0, maxX = 0, minX = 0;
            for (char c : line.toCharArray()) {
                switch (c) {
                    case 'F':
                        ny += dy[d];
                        nx += dx[d];
                        break;
                    case 'B':
                        ny += dy[(2 + d) % 4];
                        nx += dx[(2 + d) % 4];
                        break;
                    case 'L':
                        d = (1 + d) % 4;
                        break;
                    case 'R':
                        d = (3 + d) % 4;
                        break;
                }
                maxY = Math.max(maxY, ny);
                minY = Math.min(minY, ny);
                maxX = Math.max(maxX, nx);
                minX = Math.min(minX, nx);
            }
            System.out.println((maxY - minY) * (maxX - minX));
        }
    }
}
