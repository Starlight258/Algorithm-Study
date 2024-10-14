import java.util.*;

class Solution {
    Map<Integer, Integer> busIn = new HashMap<>();
    Map<Integer, Integer> busTime = new HashMap<>();
    Map<Integer, Integer> costs = new HashMap<>();
    public int[] solution(int[] fees, String[] records) {
        for (String record:records){
            String[] splited = record.split(" ");
            String time = splited[0];
            int minutes = convertToTime(time);
            int bus = Integer.parseInt(splited[1]);
            boolean isIn = splited[2].equals("IN")? true : false;
            if (isIn){
                busIn.put(bus, minutes);
            } else {
                int remain = minutes - busIn.get(bus);
                busTime.put(bus, busTime.getOrDefault(bus, 0) + remain);
                busIn.remove(bus);
            }
        }
        
        // 남은 차량은 23:59분에 출차
        for (Map.Entry<Integer, Integer> e:busIn.entrySet()){
            int remain = 23*60+59 - busIn.get(e.getKey());
            busTime.put(e.getKey(), busTime.getOrDefault(e.getKey(), 0) + remain);
        }
        // 계산
       for (Map.Entry<Integer, Integer> e:busTime.entrySet()){       
            calculateCost(e.getKey(), e.getValue(), fees);
        }
        TreeMap<Integer, Integer> tm = new TreeMap<>(costs);
        List<Integer> answer = new ArrayList<>(tm.values());
        return answer.stream().mapToInt(x->x).toArray();
    }
    private int convertToTime(String time){
        String[] splited = time.split(":");
        int h = Integer.parseInt(splited[0]);
        int m = Integer.parseInt(splited[1]);
        return h * 60 + m;
    }
    private void calculateCost(int bus, int minutes, int[] fees){
        int remain = minutes - fees[0];
        int cost = fees[1];
        if (remain>0){
            cost += (remain/fees[2] + (remain%fees[2]==0?0:1)) * fees[3];
        } 
        costs.put(bus, costs.getOrDefault(bus, 0)+cost);
    }
}
