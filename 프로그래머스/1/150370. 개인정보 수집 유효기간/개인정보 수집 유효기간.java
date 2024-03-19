import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int todayNum = 0;
        
        String[] t = today.split("\\.");
        todayNum += Integer.parseInt(t[0]) * 28*12;
        todayNum += Integer.parseInt(t[1]) * 28;
        todayNum += Integer.parseInt(t[2]);
        
        HashMap<String, Integer> mp = new HashMap<>();
        for (int i=0;i<terms.length;i++){
            String[] tList = terms[i].split(" ");
            mp.put(tList[0], Integer.parseInt(tList[1]) * 28);
        }
        
        for (int i=0;i<privacies.length;i++){
            int dayNum = 0;
            String[] s = privacies[i].split("\\.");
            dayNum += Integer.parseInt(s[0]) * 28*12;
            dayNum += Integer.parseInt(s[1]) * 28;
            dayNum += Integer.parseInt(s[2].substring(0,2));
            int addDay = mp.get(s[2].substring(3)+"");
            dayNum += addDay;
            if (dayNum <= todayNum){
                answer.add(i+1);
            }
        }
        return answer.stream().mapToInt(x->x).toArray();
    }

}