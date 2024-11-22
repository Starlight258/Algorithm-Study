import java.util.*;

class Solution {
    public int solution(int CACHESIZE, String[] CITIES) {
        int answer = 0;
        Set<String> cities = new HashSet<>();
        LinkedList<String> used = new LinkedList<>();
        if (CACHESIZE==0) return CITIES.length * 5;
        for (int i=0;i<CITIES.length;i++){
            String city = CITIES[i].toLowerCase();
            if (cities.contains(city)){
                used.remove(city);
                used.addLast(city);
                answer += 1;
                continue;
            }
            if (used.size()>=CACHESIZE){
                String oldCity = used.get(0);
                cities.remove(oldCity);
                used.remove(oldCity);
            } 
            cities.add(city);
            used.addLast(city);
            answer += 5;
        }

        return answer;
    }
}