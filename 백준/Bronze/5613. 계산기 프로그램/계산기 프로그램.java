import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = Integer.parseInt(br.readLine());
        while (true) {
            String input = br.readLine();
            if (input.equals("=")) {
                break;
            }
            int number = Integer.parseInt(br.readLine());
            switch (input) {
                case "+":
                    result += number;
                    break;
                case "-":
                    result -= number;
                    break;
                case "*":
                    result *= number;
                    break;
                case "/":
                    result /= number;
                    break;
            }
        }
        System.out.println(result);
    }
}
