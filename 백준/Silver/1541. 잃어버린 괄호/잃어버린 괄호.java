import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
    세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
    그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
    괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.
     */
    /*
    55-50+40
    - 뒤에는 다 괄호 -> 가장 최소의 값
    1-(5+6)-3 = -13
    1-(5+6-3) = -13
    1-(5+6)-3 = -13
     */
    public static void main(String[] args) throws IOException {
        // 뺄셈만 존재
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] tokens = line.split("-");
        int answer = 0;
        boolean isFirst = true;
        for (String token : tokens) {
            int num = 0;
            StringBuilder tmp = new StringBuilder();
            for (char c : token.toCharArray()) {
                if (c == '+') {
                    num += Integer.parseInt(tmp.toString());
                    tmp = new StringBuilder();
                } else {
                    tmp.append(c);
                }
            }
            if (tmp.length() != 0) {
                int num1 = Integer.parseInt(tmp.toString());
                num += num1;
            }
            if (isFirst) {
                answer = num;
                isFirst = false;
            } else {
                answer -= num;
            }
        }
        System.out.println(answer);
    }

}
