class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int amt = health;
        int time = bandage[0];
        int secRecovery = bandage[1];
        int additional = bandage[2];
        int pos = 0;
        int cnt = 0;
        int i=1; // 초
        while (i<=attacks[attacks.length-1][0]){
            if (pos < attacks.length && attacks[pos][0] == i++){
                amt -= attacks[pos][1];
                if (amt<=0) return -1;
                pos++;
                cnt = 0;
            } else {
                cnt++;
                if (amt < health){
                amt = amt+secRecovery < health ? amt+secRecovery : health;
                } 
                if (cnt == time){
                    amt = amt+additional < health ? amt+additional : health;
                    cnt = 0;
                }   
            }
        }
        return amt;
    }
}