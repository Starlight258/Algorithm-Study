import java.util.*;
import java.util.regex.*;

class Solution {
    public String[] solution(String[] files) {
        String regex = "([A-Za-z- ]+)([0-9]+)(.*)";
        Pattern pattern = Pattern.compile(regex);
        List<List<String>> splited = new ArrayList<>();
        for (String file:files){
            Matcher matcher = pattern.matcher(file);
            while (matcher.find()){
                String head = matcher.group(1);
                String number = matcher.group(2);
                String tail = matcher.groupCount()==3?matcher.group(3):"";
                splited.add(List.of(head, number, tail));                
            }
        }
        // 정렬
        Collections.sort(splited, (s1, s2)->{
            String ss1 = s1.get(0).toLowerCase();
            String ss2 = s2.get(0).toLowerCase();
            int result = ss1.compareTo(ss2);
            if (result != 0){
                return result;
            }
            int number1 = Integer.parseInt(s1.get(1));
            int number2 = Integer.parseInt(s2.get(1));
            return Integer.compare(number1, number2);
        });
        List<String> answer = new ArrayList<>();
        for (List<String> split:splited){
            answer.add(String.join("", split));
        }
        return answer.toArray(new String[0]);
    }
}