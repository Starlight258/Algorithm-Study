import java.util.*;

class Solution {
    public int solution(int[] toppings) {
        int answer = 0;
        int[] sortAsc = new int[toppings.length];
        Map<Integer, Integer> toppingAsc = new HashMap<>();
        int[] sortDesc = new int[toppings.length];
        Map<Integer, Integer> toppingDesc = new HashMap<>();
        // 오름차순
        toppingAsc.put(toppings[0], 1);
        sortAsc[0] = 1;
        for (int i=1;i<toppings.length;i++){
            if (toppingAsc.getOrDefault(toppings[i], 0) == 0){
                toppingAsc.put(toppings[i], 1);
                sortAsc[i] = sortAsc[i-1]+1;
            } else {
                sortAsc[i] = sortAsc[i-1];
            }
        }
        // 내림차순
        toppingDesc.put(toppings[toppings.length-1], 1);
        sortDesc[toppings.length-1] = 1;
        for (int i=toppings.length-2;i>=0;i--){
            if (toppingDesc.getOrDefault(toppings[i], 0) == 0){
                toppingDesc.put(toppings[i], 1);
                sortDesc[i] = sortDesc[i+1]+1;
            } else {
                sortDesc[i] = sortDesc[i+1];
            }
        }
        // 개수 세기
        boolean isContinuous = false;
        for (int i=1;i<toppings.length;i++){
            if (sortAsc[i] - sortDesc[i] <= 1){ // 흐름이 역전될때
                if (sortAsc[i-1] == sortDesc[i]){
                    answer++;
                }
            } 
        }
        return answer;
    }
}

// 토핑 종류를 공평하게 분배하기
// 순서O, 토핑 종류가 같도록 나누기
// 0 ~ i-1번째까지의 토핑수 = i번째부터 끝까지의 토핑수