import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder("");
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
            answer.append(num[i]);
        }
        if (answer.substring(0,1).equals("0")) return "0";
        return answer.toString();
    }
}