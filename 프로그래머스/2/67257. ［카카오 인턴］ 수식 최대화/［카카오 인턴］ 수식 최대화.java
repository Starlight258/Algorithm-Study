import java.util.*;

class Solution {
    static long answer = 0;
    static long[] numbers;
    static String[] operators;
    
    void dfs(List<String> priority, boolean[] visited) {
        if (priority.size() == 3) {
            calculate(priority);
            return;
        }
        for (String op : new String[]{"+", "-", "*"}) {
            if (!visited[getOpIndex(op)]) {
                visited[getOpIndex(op)] = true;
                priority.add(op);
                dfs(priority, visited);
                priority.remove(priority.size() - 1);
                visited[getOpIndex(op)] = false;
            }
        }
    }

    private int getOpIndex(String op) {
        return op.equals("+") ? 0 : (op.equals("-") ? 1 : 2);
    }

    public void calculate(List<String> priority) {
        ArrayList<Long> nums = new ArrayList<>(Arrays.asList(Arrays.stream(numbers).boxed().toArray(Long[]::new)));
        ArrayList<String> ops = new ArrayList<>(Arrays.asList(operators));

        for (String op : priority) {
            for (int i = 0; i < ops.size(); i++) {
                if (ops.get(i).equals(op)) {
                    long result = applyOperator(nums.get(i), nums.get(i + 1), op);
                    nums.set(i, result);
                    nums.remove(i + 1);
                    ops.remove(i);
                    i--;
                }
            }
        }

        answer = Math.max(answer, Math.abs(nums.get(0)));
    }

    private long applyOperator(long a, long b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            default: throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }

    public long solution(String expression) {
        String[] numStrings = expression.split("[+\\-*]");
        numbers = Arrays.stream(numStrings).mapToLong(Long::parseLong).toArray();
        operators = expression.replaceAll("\\d+", "").split("");

        dfs(new ArrayList<>(), new boolean[3]);
        return answer;
    }
}