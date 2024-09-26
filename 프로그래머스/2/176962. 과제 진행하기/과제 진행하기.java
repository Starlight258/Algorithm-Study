import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        // 정렬하기
        Arrays.sort(plans, (String[] p1, String[] p2) -> convertToMinutes(p1[1]) - convertToMinutes(p2[1]));
        
        List<String> list = new ArrayList<>();
        Stack<int[]> stk = new Stack<>();
        
        for (int i=0;i<plans.length;i++){
            String[] plan = plans[i];
            int now = convertToMinutes(plans[i][1]);
            int minutes = Integer.parseInt(plan[2]);
            
            int nextStartTime=0;
            if (i == plans.length-1){
                nextStartTime = Integer.MAX_VALUE;
            } else {
                nextStartTime = convertToMinutes(plans[i+1][1]);                
            }
            
            int endTime = now + minutes;
            if (endTime > nextStartTime){
                stk.add(new int[]{i, endTime - nextStartTime}); // 잠시 멈춘 과제
            } else {
                list.add(plans[i][0]);
                if (endTime == nextStartTime){
                    continue;
                } else { // 시간 남으면 가장 최근에 멈춘 과제 수행하기
                    int remain = nextStartTime - endTime;
                    while (true){
                        if (stk.isEmpty() || remain<=0){
                            break;
                        }
                        int[] recent = stk.pop();
                        if (recent[1] > remain){
                            stk.push(new int[]{recent[0], recent[1]-remain});
                            break;
                        } else {
                            list.add(plans[recent[0]][0]);
                            remain -= recent[1];
                        }    
                    }
                }
            }
        }
        
        return list.toArray(new String[0]);
    }
    private int convertToMinutes(String time){
        String[] splitedTime = time.split(":");
        int h = Integer.parseInt(splitedTime[0]);
        int m = Integer.parseInt(splitedTime[1]);
        return h * 60 + m;
    }
}