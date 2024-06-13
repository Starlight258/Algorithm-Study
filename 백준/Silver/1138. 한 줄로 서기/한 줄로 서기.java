import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
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
        LinkedList<Integer> line = new LinkedList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                line.addFirst(i + 1);
            } else {
                line.add(arr[i], i + 1);
            }
        }
        for (Integer integer : line) {
            System.out.print(integer + " ");
        }
    }
}
