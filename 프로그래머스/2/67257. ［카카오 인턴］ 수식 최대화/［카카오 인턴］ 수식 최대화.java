import java.util.*;
import java.util.regex.*;

class Solution {
    private static final Pattern PATTERN = Pattern.compile("(\\W*)(\\d+)");

    public long solution(String expression) {
        long answer = 0;
        // 완전탐색
        // 수식 모든 경우의 수
        List<String> ops = new ArrayList<>();
        List<Long> numbers = new ArrayList<>();
        Matcher matcher = PATTERN.matcher(expression);
        while (matcher.find()){
            if (!matcher.group(1).isEmpty()) ops.add(matcher.group(1));
            numbers.add(Long.parseLong(matcher.group(2)));         
        }
        List<String> uniqueOps = new ArrayList<>(new HashSet<>(ops));
        List<String> opsNumber = new ArrayList<>();
        makeOps(opsNumber, "", uniqueOps);
        // 순서대로 진행해보기
        for (String op:opsNumber){
            List<String> tmpOps = new ArrayList<>(ops);
            List<Long> tmpNumbers = new ArrayList<>(numbers);
            for (char c:op.toCharArray()){ // 순서대로
                while (tmpOps.contains(""+c)){
                    int index = tmpOps.indexOf(c+"");
                    if (index==-1) continue;
                    long number = tmpNumbers.get(index);
                    if (c=='+'){
                        number += tmpNumbers.get(index+1);
                    }
                    if (c=='-'){
                        number -= tmpNumbers.get(index+1);
                    }
                    if (c=='*'){
                        number *= tmpNumbers.get(index+1);
                    }
                    tmpNumbers.remove(index);
                    tmpNumbers.remove(index);
                    tmpNumbers.add(index, number);
                    tmpOps.remove(index);
                }
                
            }
            answer = Math.max(answer, Math.abs(tmpNumbers.get(0)));
        }

        return answer;
    }
    
    private void makeOps(List<String> opsNumber, String op, List<String> uniqueOps){
        if (op.length()==uniqueOps.size()){
            opsNumber.add(op);
            return;
        }
        if (op.length()>uniqueOps.size()) return;
        for (int i=0;i<uniqueOps.size();i++){
            if (op.contains(uniqueOps.get(i))) continue;
            makeOps(opsNumber, op+uniqueOps.get(i), uniqueOps);
        }
    }
}