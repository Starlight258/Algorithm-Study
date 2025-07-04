import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] roadLength = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            roadLength[i] = Integer.parseInt(st.nextToken());
        }
        int[] price = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
        // 최소 주유소 금액을 저장, 더 비싸면 가격 더하기, 싸면 가격 안더하기
        long minPrice = Long.MAX_VALUE;
        long total = 0;
        for (int i = 0; i < n - 1; i++) {
            if (minPrice > price[i]) {
                minPrice = price[i];
            }
            total += minPrice * roadLength[i];
        }
        System.out.println(total);
    }
}
