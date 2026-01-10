import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    /*
    옛날 옛적에 수학이 항상 큰 골칫거리였던 나라가 있었다. 이 나라의 국왕 김지민은 다음과 같은 문제를 내고 큰 상금을 걸었다.
    길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.
    S = A[0] × B[0] + ... + A[N-1] × B[N-1]
    S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다.
    S의 최솟값을 출력하는 프로그램을 작성하시오.
     */
    /*
    가장 작은 값 * 가장 큰 값
    가장 큰 값 * 가장 작은 값
    B 오름차순 정렬
    A 내림차순 정렬
    A[i] * B[i] = 최솟값
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a, Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(b);
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += a[i] * b[i];
        }
        System.out.println(answer);
    }

}
