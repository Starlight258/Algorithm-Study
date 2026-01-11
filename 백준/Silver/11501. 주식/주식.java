import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    홍준이는 요즘 주식에 빠져있다. 그는 미래를 내다보는 눈이 뛰어나, 날 별로 주가를 예상하고 언제나 그게 맞아떨어진다. 매일 그는 아래 세 가지 중 한 행동을 한다.
    주식 하나를 산다.
    원하는 만큼 가지고 있는 주식을 판다.
    아무것도 안한다.
    홍준이는 미래를 예상하는 뛰어난 안목을 가졌지만, 어떻게 해야 자신이 최대 이익을 얻을 수 있는지 모른다.
    따라서 당신에게 날 별로 주식의 가격을 알려주었을 때, 최대 이익이 얼마나 되는지 계산을 해달라고 부탁했다.
    예를 들어 날 수가 3일이고 날 별로 주가가 10, 7, 6일 때, 주가가 계속 감소하므로 최대 이익은 0이 된다.
    그러나 만약 날 별로 주가가 3, 5, 9일 때는 처음 두 날에 주식을 하나씩 사고, 마지막날 다 팔아 버리면 이익이 10이 된다.
     */

    /**
     3
     3
     10 7 6 -> 0
     3
     3 5 9 -> 9-3 + 9-5 = 10
     5
     1 1 3 1 2 -> 3-1 + 3-1 = 4
     1 1 4 1 3 -> 3-1 + 3-1 = 4
     오르면 그 이전꺼 차이만큼 더하고, 오르지 않으면 차이 안더함
     int prev(cur이 업데이트될때만 갱신), cur(계속 1씩 증가) -> num[prev] < num[cur]
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] nums = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            int max = nums[n - 1];
            long answer = 0;
            for (int i = n - 2; i >= 0; i--) {
                if (max < nums[i]) {
                    max = nums[i];
                } else {
                    answer += max - nums[i];
                }
            }
            System.out.println(answer);
        }
    }

}
