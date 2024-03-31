import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] num = new String[numbers.length];
        for (int i=0;i<numbers.length;i++){
            num[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(num, new Comparator<String>(){
            public int compare(String x, String y){
                return (y+x).compareTo(x+y); // 내림차순
            }
        });
        for (int i=0;i<num.length;i++){
            answer += num[i];
        }
        if (answer.startsWith("0")) return "0";
        return answer;
    }
}