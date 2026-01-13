import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    /*
    몇 개의 자연수로 이루어진 두 집합 A와 B가 있다. 집합 A에는 속하면서 집합 B에는 속하지 않는 모든 원소를 구하는 프로그램을 작성하시오.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int na = Integer.parseInt(st.nextToken());
        int nb = Integer.parseInt(st.nextToken());
        int[] a = new int[na];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < na; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] b = new int[nb];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nb; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(b);

        List<Integer> answer = new ArrayList<>();
        for (int num : a) {
            if (!binarySearch(num, nb, b)) { // b에서 a를 찾음
                answer.add(num);
            }
        }
        System.out.println(answer.size());
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for (Integer ans: answer) {
            sb.append(ans).append(" ");
        }
        System.out.println(sb);
    }

    private static boolean binarySearch(final int num, final int nb, final int[] b) {
        int left = 0;
        int right = nb - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (b[mid] == num) {
                return true;
            } else if (b[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

}
