import java.util.*;

class Solution {
    class Assignment {
        String name;
        int start;
        int playTime;

        Assignment(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
    }

    int calculateTime(String time) {
        String[] splitTime = time.split(":");
        return Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
    }

    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<String>();
        List<Assignment> list = new ArrayList<Assignment>();

        for (int i = 0; i < plans.length; i++) {
            String[] plan = plans[i];
            list.add(new Assignment(plan[0], calculateTime(plan[1]), Integer.parseInt(plan[2])));
        }

        Collections.sort(list, (a1, a2) -> a1.start - a2.start);

        Stack<Assignment> stack = new Stack<>();
        int currentTime = list.get(0).start;

        for (int pos = 0; pos < list.size(); pos++) {
            Assignment current = list.get(pos);

            while (!stack.isEmpty() && currentTime + stack.peek().playTime <= current.start) {
                Assignment completed = stack.pop();
                answer.add(completed.name);
                currentTime += completed.playTime;
            }

            if (!stack.isEmpty()) {
                Assignment paused = stack.pop();
                paused.playTime -= current.start - currentTime;
                stack.push(paused);
            }

            currentTime = current.start;
            stack.push(current);
        }

        while (!stack.isEmpty()) {
            Assignment completed = stack.pop();
            answer.add(completed.name);
        }

        return answer.toArray(new String[0]);
    }
}