import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //2. 플러그 빼기
        boolean[] use = new boolean[101];
        int put = 0;
        int answer = 0;
        for (int i = 0; i < k; i++) {
            int temp = arr[i];
            if (!use[temp]) {
                if (put < n) {
                    use[temp] = true;
                    put++;
                } else {
                    ArrayList<Integer> arrList = new ArrayList<>();
                    for (int j = i; j < k; j++) { // 현재 이후에 사용되는 콘센트 조사
                        if (use[arr[j]] && !arrList.contains(arr[j])) {
                            arrList.add(arr[j]);
                        }
                    }
                    boolean flag = false;
                    for (int j = 0; j < use.length; j++) {
                        if (use[j] && !arrList.contains(j)) {
                            use[j] = false;
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        int remove = arrList.get(arrList.size() - 1);
                        use[remove] = false;
                    }
                    use[temp] = true;
                    answer++;
                }
            }
        }

        //3. 정답 출력
        System.out.println(answer);
    }
}
