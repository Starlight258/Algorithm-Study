
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] list = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i=0;i<n;i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        int answer = 0;
        int sum = 0;
        for (int i=0;i<n;i++){
            sum += list[i];
            answer += sum;
        }
        System.out.println(answer);
    }

}
