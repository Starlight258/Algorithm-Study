import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] led = {{1, 1, 1, 0, 1, 1, 1}, //0
            {0, 0, 1, 0, 0, 0, 1}, //1
            {0, 1, 1, 1, 1, 1, 0}, //2
            {0, 1, 1, 1, 0, 1, 1}, //3
            {1, 0, 1, 1, 0, 0, 1}, //4
            {1, 1, 0, 1, 0, 1, 1}, //5
            {1, 1, 0, 1, 1, 1, 1}, //6
            {0, 1, 1, 0, 0, 0, 1}, //7
            {1, 1, 1, 1, 1, 1, 1}, //8
            {1, 1, 1, 1, 0, 1, 1}}; //9
    static int n;
    static int k;
    static int p;
    static int x;

    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        // 숫자 만들기
        int answer = 0;
        int[] num = makeNum(x);
        for (int i = 1; i <= n; i++) {
            if (i == x) {
                continue;
            }
            int[] compareNum = makeNum(i);
            // 숫자 비교
            int count = 0;
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < 7; l++) {
                    if (led[num[j]][l] != led[compareNum[j]][l]) {
                        count++;
                    }
                    if (count > p) {
                        break;
                    }
                }
            }
            if (count <= p) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static int[] makeNum(int num) {
        int[] arr = new int[k];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = num % 10;
            num /= 10;
        }
        return arr;
    }
}
