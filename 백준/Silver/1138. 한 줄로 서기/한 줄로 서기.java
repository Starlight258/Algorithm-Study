import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //2. 줄 서기
        List<Integer> line = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            line.add(arr[i], i + 1);
        }
        for (Integer integer : line) {
            System.out.print(integer + " ");
        }
    }
}
