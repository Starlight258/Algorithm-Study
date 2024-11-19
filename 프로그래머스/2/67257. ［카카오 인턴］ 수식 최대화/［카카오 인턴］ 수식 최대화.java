import java.util.*;
import java.util.regex.*;

class Solution {

    public long solution(String expression) {
        long answer = 0;
        List<String> tokens = splitExpression(expression);
        
        // 고유한 연산자 추출
        Set<String> operatorsUnique = new HashSet<>();
        for (String token:tokens){
            if (!token.matches("\\d+")){
                operatorsUnique.add(token);
            }
        }    
        
        // 연산자 모든 조합 생성
        List<String> operators = new ArrayList<>(operatorsUnique);
        List<List<String>> priorities = new ArrayList<>();
        generatePermutations(operators, priorities, new ArrayList<>());
        
        // 계산하여 최댓값 찾기
        long maxResult = 0;
        for (List<String> priority:priorities){
            long result = Math.abs(calculateWithPriority(new ArrayList<>(tokens), priority));
            maxResult = Math.max(maxResult, result);
        }
        return maxResult;
    }
    
    private long calculateWithPriority(List<String> tokens, List<String> priority){
        for (String op:priority){
            for (int i=1;i<tokens.size();i+=2){
                if (tokens.get(i).equals(op)){
                    long number = calculate(tokens.get(i), tokens.get(i-1), tokens.get(i+1));
                    tokens.set(i-1, String.valueOf(number));
                    tokens.remove(i);
                    tokens.remove(i);
                    i -=2;
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }
    
    private long calculate(String op, String number1, String number2){
        long number = Long.parseLong(number1);
        if (op.equals("+")){
            number += Long.parseLong(number2);
        } else if (op.equals("-")){
            number -= Long.parseLong(number2);
        } else if (op.equals("*")){
            number *= Long.parseLong(number2);
        }
        return number;
    }
    
    private void generatePermutations(List<String> operators,  List<List<String>> result, List<String> current){
        if (current.size() == operators.size()){
            result.add(new ArrayList<>(current));
            return;
        }
        for (String op:operators){
            if (!current.contains(op)){
                current.add(op);
                generatePermutations(operators, result, current);
                current.remove(current.size()-1);
            }
        }
    }

    
    private List<String> splitExpression(String expression){
        List<String> tokens = new ArrayList<>();
        StringBuilder number = new StringBuilder();
        for (char c:expression.toCharArray()){
            if (Character.isDigit(c)){
                number.append(c);
            } else {
                tokens.add(number.toString());
                tokens.add(String.valueOf(c));
                number = new StringBuilder();
            }
        }
        tokens.add(number.toString());
        return tokens;
    }
}