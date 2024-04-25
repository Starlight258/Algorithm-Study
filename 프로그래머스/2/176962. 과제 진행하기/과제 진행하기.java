import java.util.*;
class Solution {
    class Assignment{
        String name;
        int start;
        int playTime;
        Assignment(String name, int start, int playTime){
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
    }
    int calculateTime(String time){
        String[] splitTime = time.split(":");
        return Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
    }
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<String>();
        List<Assignment> list = new ArrayList<Assignment>();
        for (int i=0;i<plans.length;i++){
            String[] plan = plans[i];
            list.add(new Assignment(plan[0], calculateTime(plan[1]), Integer.parseInt(plan[2])));
        }
        Collections.sort(list, (a1, a2)-> a1.start - a2.start);
        Stack<Assignment> stk = new Stack<>();
        for (int pos=0;pos<list.size();pos++){
            System.out.println(pos +"," + list.size());
            while (!stk.isEmpty() && pos<list.size()){
                Assignment a1 = stk.peek();
                int currentTime = a1.start;
                System.out.println(a1.name);
                if (a1.start + a1.playTime <=list.get(pos).start){
                    answer.add(a1.name);
                    stk.pop();
                } else {
                    a1.playTime = list.get(pos+1).start - a1.start;
                    break;
                }
            }
            stk.push(list.get(pos));
        }
        return answer.toArray(new String[0]);
    }
}