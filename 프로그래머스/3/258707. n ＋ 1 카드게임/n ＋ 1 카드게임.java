import java.util.*;

class Solution {
    private int n;
    private int pos = 0;
    private Set<Integer> original;
    private Set<Integer> additional;
    
    public int solution(int coin, int[] cards) {
        int round = 0;
        n = cards.length;
        original = new HashSet<>();
        additional = new HashSet<>();
        getCards(cards, n/3);
        int sum = n+1;
        
        while (true){
            round++;
            if (original.isEmpty() || pos==n){
                break;
            }
            additional.add(cards[pos++]);
            additional.add(cards[pos++]);
            boolean flag = false;
            // 최초 카드에서 해결가능한지 확인
            for (int item:original){
                if (original.contains(sum - item)){
                    original.remove(item);
                    original.remove(sum - item);
                    flag = true; // 다음 라운드
                    break;
                }
            }
            if (flag) continue;
            // 한개의 카드를 사용해서 확인
            if (coin<1) break; 
            for (int item:original){
                if (additional.contains(sum - item)){
                    original.remove(item);
                    flag = true;
                    coin--;
                    break;
                }
            }
            if (flag) continue;
            // 두개의 카드를 사용해서 확인
            if (coin<2) break; 
            for (int item:additional){
                if (additional.contains(sum - item)){
                    additional.remove(item);
                    additional.remove(sum - item);
                    flag = true;
                    coin -= 2;
                    break;
                }
            }
            if (!flag) break;
        }
        return round;
    }
    
    private void getCards(int[] cards, int num){
        for (int i=0;i<num;i++){
            original.add(cards[pos++]);
        }
    }
}