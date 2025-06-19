import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 1. 입력받기
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        // 2. a 이동하며 b와 차이가 적은 문자열 위치 구하기
        int optCount = a.length();
        for (int start = 0; start <= b.length() - a.length(); start++) {
            int count = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(start + i)) {
                    count++;
                }
            }
            if (count < optCount) {
                optCount = count;
            }
        }
        System.out.println(optCount);
    }
}
