import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int currentTime = 0;
        int currentIndex = k - 1;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char z = st.nextToken().charAt(0);
            currentTime += t;
            if (currentTime >= 210) {
                System.out.println(currentIndex + 1);
                break;
            }
            if (z == 'T') {
                currentIndex = (currentIndex + 1 + 8) % 8;
            }
        }

    }
}
