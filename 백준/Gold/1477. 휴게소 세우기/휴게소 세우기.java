import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*
    다솜이는 유료 고속도로를 가지고 있다.
    다솜이는 현재 고속도로에 휴게소를 N개 가지고 있는데, 휴게소의 위치는 고속도로의 시작으로부터 얼만큼 떨어져 있는지로 주어진다.
    다솜이는 지금 휴게소를 M개 더 세우려고 한다.

    다솜이는 이미 휴게소가 있는 곳에 휴게소를 또 세울 수 없고, 고속도로의 끝에도 휴게소를 세울 수 없다.
    휴게소는 정수 위치에만 세울 수 있다.

    다솜이는 이 고속도로를 이용할 때, 모든 휴게소를 방문한다.
    다솜이는 휴게소를 M개 더 지어서 휴게소가 없는 구간의 길이의 최댓값을 최소로 하려고 한다. (반드시 M개를 모두 지어야 한다.)

    예를 들어, 고속도로의 길이가 1000이고, 현재 휴게소가 {200, 701, 800}에 있고, 휴게소를 1개 더 세우려고 한다고 해보자.

    일단, 지금 이 고속도로를 타고 달릴 때, 휴게소가 없는 구간의 최댓값은 200~701구간인 501이다.
    하지만, 새로운 휴게소를 451구간에 짓게 되면, 최대가 251이 되어서 최소가 된다.
     */
    /*
   그리디 -> 사이 거리의 절반에 계속 휴게소 넣기
   반례) 만약 휴게소가 없다면 1000 -> (1) 250 500 (1000)... X : 최적해는 (1) 333 666 (1000)
   이분 탐색) 거리 = mid
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] machines = new int[n + 2];
        st = new StringTokenizer(br.readLine());
        machines[0] = 0;
        machines[n + 1] = l;
        for (int i = 1; i <= n; i++) {
            machines[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(machines);
        int left = 1;
        int right = l - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int count = 0;
            for (int i = 1; i <= n + 1; i++) {
                int distance = machines[i] - machines[i - 1] - 1;
                if (distance >= mid) {
                    count += distance / mid;
                }
            }
            if (count > m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }

}
