import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static String arr[], result[];
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(bf.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bf.readLine());

            arr = new String[n];
            result = new String[n];
            answer = Integer.MAX_VALUE;

            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = st.nextToken();
            }

            if (n > 32) {
                answer = 0;
            } else {
                search(0, 0);
            }

            bw.write(answer + "\n");
        }
        bw.flush();
    }

    private static void search(int idx, int start) {
        if (idx == 3) {
            int temp = 0;
            for (int i = 0; i < 4; i++) {
                if (result[0].charAt(i) != result[1].charAt(i)) {
                    temp += 1;
                }
                if (result[1].charAt(i) != result[2].charAt(i)) {
                    temp += 1;
                }
                if (result[0].charAt(i) != result[2].charAt(i)) {
                    temp += 1;
                }
            }
            answer = Math.min(temp, answer);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            result[idx] = arr[i];
            search(idx + 1, i + 1);
        }
    }
}
