import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int getDate(String day){
        String[] dayList = day.split("\\.");
        int dayNum = Integer.parseInt(dayList[0]) * 28*12;
        dayNum += Integer.parseInt(dayList[1]) * 28;
        dayNum += Integer.parseInt(dayList[2]);
        return dayNum;
    }
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int todayNum = getDate(today);
        
        HashMap<String, Integer> mp = new HashMap<>();
        for (int i=0;i<terms.length;i++){
            String[] tList = terms[i].split(" ");
            mp.put(tList[0], Integer.parseInt(tList[1]) * 28);
        }
        
        for (int i=0;i<privacies.length;i++){
            String[] s = privacies[i].split(" ");
            int dayNum = getDate(s[0]);
            
            int addDay = mp.get(s[1]);
            dayNum += addDay;
            if (dayNum <= todayNum){
                answer.add(i+1);
            }
        }
        return answer.stream().mapToInt(x->x).toArray();
    }

}