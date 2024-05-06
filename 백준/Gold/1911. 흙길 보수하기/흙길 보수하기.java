
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import javax.lang.model.SourceVersion;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] waterPool = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            waterPool[i][0] = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            waterPool[i][1] = v == 0 ? 0 : v - 1;
        }

        Arrays.sort(waterPool, Comparator.comparingInt(a -> a[0]));

        int pos = waterPool[0][0];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            pos = Math.max(pos, waterPool[i][0]);
            while (pos <= waterPool[i][1]) {
                pos += l;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
