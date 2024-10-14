import java.util.*;

class Solution {
    private static final int END_OF_DAY_MINUTES = 23 * 60 + 59;
    
    Map<Integer, Integer> carEntryTimes = new HashMap<>();
    Map<Integer, Integer> carParkingDurations = new HashMap<>();
    Map<Integer, Integer> carFees = new HashMap<>();
    public int[] solution(int[] fees, String[] records) {
        for (String record:records){
            String[] splited = record.split(" ");
            String time = splited[0];
            int minutes = convertToTime(time);
            int bus = Integer.parseInt(splited[1]);
            boolean isIn = splited[2].equals("IN")? true : false;
            if (isIn){
                carEntryTimes.put(bus, minutes);
            } else {
                int remain = minutes - carEntryTimes.get(bus);
                carParkingDurations.put(bus, carParkingDurations.getOrDefault(bus, 0) + remain);
                carEntryTimes.remove(bus);
            }
        }
        
        // 남은 차량은 23:59분에 출차
        for (Map.Entry<Integer, Integer> e:carEntryTimes.entrySet()){
            int remain = END_OF_DAY_MINUTES - carEntryTimes.get(e.getKey());
            carParkingDurations.put(e.getKey(), carParkingDurations.getOrDefault(e.getKey(), 0) + remain);
        }
        // 계산
       for (Map.Entry<Integer, Integer> e:carParkingDurations.entrySet()){       
            calculateCost(e.getKey(), e.getValue(), fees);
        }
        TreeMap<Integer, Integer> tm = new TreeMap<>(carFees);
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
            cost += (int)Math.ceil((double)remain/fees[2]) * fees[3];
        } 
        carFees.put(bus, carFees.getOrDefault(bus, 0)+cost);
    }
}
